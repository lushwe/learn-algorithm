package com.lushwe.algorithm.ant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 说明：题目1：线程A负责实时往Map里put 1-100的数字，线程B负责实时从这个map中get数字并进行累加（A放入MAP一个值后，B取出来,然后A继续放，B继续取，以此循环一直到A放完100，B取完100,结束），B实时打印当前时刻累加的结果。
 *
 * @author Jack Liu
 * @date 2019-11-11 19:06
 * @since 0.1
 */
public class TestOne {

    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();


    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                map.put(i, i);
            }
        });


        Thread thread2 = new Thread(() -> {

            int sum = 0;

            for (int j = 1; j <= 100; j++) {

                while (!map.containsKey(j)) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Integer value = map.get(j);
                sum = sum + value;
                System.out.println(" 当前取出" + j + "，累加的结果：" + sum);
            }
        });

        thread1.start();
        thread2.start();
    }

}
