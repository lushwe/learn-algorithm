package com.lushwe.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 说明：三个线程同时启动，顺序打印26个字母
 *
 * @author Jack Liu
 * @date 2020-08-07 22:09
 * @since 0.1
 */
public class ThreeThreadSortPrintln {

    private static volatile int curr = 0;

    private static ReentrantLock lock = new ReentrantLock();
    private static List<Condition> conditions = new ArrayList<>();


    public static void main(String[] args) {

//        sortPrintlnOne();
//        sortPrintlnTwo();
//        sortPrintlnThree();
//        sortPrintlnFour();

    }

    /**
     * 方法四：每个线程一个信号量，开始的时候都阻塞，然后唤醒第一个，然后第一个唤醒第二个，以此类推
     */
    private static void sortPrintlnFour() {

        // 线程数
        int n = 3;
        // 26个字母
        int max = 25;

        for (int i = 0; i < n; i++) {
            conditions.add(lock.newCondition());
        }

        for (int i = 0; i < n; i++) {
            new Thread(new PrintTaskFour(i, n, max), "Thread" + i).start();
        }

        // 唤醒第一个线程
        lock.lock();
        conditions.get(0).signal();
        lock.unlock();
    }


    /**
     * 方法三：每个线程一个信号量
     */
    private static void sortPrintlnThree() {

        // 线程数
        int n = 3;
        // 26个字母
        int max = 25;


        for (int i = 0; i < n; i++) {
            conditions.add(lock.newCondition());
        }

        for (int i = 0; i < n; i++) {
            new Thread(new PrintTaskThree(i, n, max), "Thread" + i).start();
        }
    }


    /**
     * 方法二：轮询判断任务是否属于该线程，简单，但是需要轮询，效率低
     */
    private static void sortPrintlnTwo() {

        // 线程数
        int n = 3;
        // 26个字母
        int max = 25;

        for (int i = 0; i < n; i++) {
            new Thread(new PrintTask(i, n, max), "Thread" + i).start();
        }
    }

    static class PrintTaskFour implements Runnable {

        private int i;
        private int n;
        private int max;

        public PrintTaskFour(int i, int n, int max) {
            this.i = i;
            this.n = n;
            this.max = max;
        }

        @Override
        public void run() {

            try {
                lock.lock();
                conditions.get(i).await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            while (curr <= max) {
                try {
                    lock.lock();
                    if (curr <= max) {
                        System.out.println(Thread.currentThread().getName() + " 打印 " + (char) (97 + curr));
                        curr++;
                        if (curr <= max) {
                            // 唤醒下一个线程
                            conditions.get((i + 1) % n).signal();
                            if (curr <= max - n + 1) {
                                conditions.get(i).await();
                            } else {
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintTaskThree implements Runnable {

        private int i;
        private int n;
        private int max;

        public PrintTaskThree(int i, int n, int max) {
            this.i = i;
            this.n = n;
            this.max = max;
        }

        @Override
        public void run() {

            while (curr <= max) {
                lock.lock();
                try {
                    if (curr % n == i) {
                        if (curr <= max) {
                            System.out.println(Thread.currentThread().getName() + " 打印 " + (char) (97 + curr));
                            curr++;
                            if (curr <= max) {
                                // 唤醒下一个线程
                                conditions.get((i + 1) % n).signal();
                                if (curr <= max - n + 1) {
                                    // 当前线程等待
                                    conditions.get(i).await();
                                } else {
                                    break;
                                }
                            }
                        }
                    } else {
                        conditions.get(i).await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintTask implements Runnable {

        private int i;
        private int n;
        private int max;

        public PrintTask(int i, int n, int max) {
            this.i = i;
            this.n = n;
            this.max = max;
        }

        @Override
        public void run() {
            while (curr <= max) {
                if (i == curr % n) {
                    synchronized (this) {
                        if (curr <= max) {
                            System.out.println(Thread.currentThread().getName() + " 打印 " + (char) (97 + curr));
                            curr++;
                        }
                    }
                }
            }
        }
    }

    /**
     * 自己想出来的方案，利用线程挂起
     */
    private static void sortPrintlnOne() {

        final List<Thread> threads = new ArrayList<>(3);
        final CountDownLatch latch = new CountDownLatch(1);
        final AtomicInteger index = new AtomicInteger(97);
        final int max = 122;

        Thread t1;
        Thread t2;
        Thread t3;

        t1 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (index.get() < max) {
                System.out.println(Thread.currentThread().getName() + " 打印 " + (char) index.getAndIncrement());
                LockSupport.unpark(threads.get(1));
                LockSupport.park();
            }
        }, "线程1");

        t2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (index.get() < max) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " 打印 " + (char) index.getAndIncrement());
                LockSupport.unpark(threads.get(2));
            }
        }, "线程2");
        t3 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (index.get() < max) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " 打印 " + (char) index.getAndIncrement());
                LockSupport.unpark(threads.get(0));
            }
        }, "线程3");

        threads.add(t1);
        threads.add(t2);
        threads.add(t3);

        t1.start();
        t2.start();
        t3.start();

        latch.countDown();
    }
}
