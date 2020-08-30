package com.lushwe.algorithm.sort;

import java.util.Arrays;

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

        System.out.println("排序前：" + Arrays.toString(in));

        int[] out = doSort(in);

        if (out == null || out.length == 0) {
            throw new IllegalArgumentException("数组结果不合法");
        }

        System.out.println("排序后：" + Arrays.toString(in));

        return out;

    }

    protected abstract int[] doSort(int[] in);
}
