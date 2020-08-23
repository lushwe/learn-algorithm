package com.lushwe.algorithm.sort;

/**
 * 说明：数组排序
 *
 * @author Jack Liu
 * @date 2019-05-14 15:31
 * @since 1.0
 */
public abstract class AbstractArraySort implements ArraySort {

    @Override
    public int[] sort(int[] in) {

        if (in == null || in.length == 0) {
            throw new IllegalArgumentException("数组参数不合法");
        }

        System.out.print("排序前：");
        for (int i = 0; i < in.length; i++) {
            System.out.print(" ");
            System.out.print(in[i]);
        }

        int[] out = doSort(in);


        if (out == null || out.length == 0) {
            throw new IllegalArgumentException("数组结果不合法");
        }

        System.out.println();

        System.out.print("排序后：");
        for (int i = 0; i < out.length; i++) {
            System.out.print(" ");
            System.out.print(out[i]);
        }

        return out;

    }

    protected abstract int[] doSort(int[] in);
}
