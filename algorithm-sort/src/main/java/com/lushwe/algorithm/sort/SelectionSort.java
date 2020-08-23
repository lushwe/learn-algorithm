package com.lushwe.algorithm.sort;

/**
 * 说明：选择排序
 *
 * @author Jack Liu
 * @date 2019-05-14 15:34
 * @since 1.0
 */
public class SelectionSort extends AbstractArraySort {


    /**
     * 选择排序
     * 每次选择一个最大/最小的数
     * 时间复杂度 O(n^2)
     *
     * @param in
     * @return
     */
    @Override
    protected int[] doSort(int[] in) {

        for (int i = 0; i < in.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < in.length; j++) {

                if (in[j] < in[min]) {

                    min = j;
                }
            }

            if (min != i) {
                int temp = in[i];
                in[i] = in[min];
                in[min] = temp;
            }
        }

        return in;
    }
}
