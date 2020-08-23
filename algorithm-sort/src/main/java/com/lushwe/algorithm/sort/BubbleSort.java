package com.lushwe.algorithm.sort;

/**
 * 说明：冒泡排序
 *
 * @author Jack Liu
 * @date 2019-05-14 15:34
 * @since 1.0
 */
public class BubbleSort extends AbstractArraySort {

    /**
     * 冒泡排序
     * 数组相邻位置的元素比较，一轮排序后，最大的元素会被放到最后一个位置，依次类推，类似冒泡一样
     * 时间复杂度O(n^2)
     *
     * @param in
     * @return
     */
    @Override
    protected int[] doSort(int[] in) {

        for (int i = 1; i < in.length; i++) {

            // 记录下面的循环中，元素前后是否有交换过位置，没有交换过位置表示已经有序，可以直接返回
            boolean flag = true;

            for (int j = 0; j < in.length - i; j++) {
                if (in[j] > in[j + 1]) {
                    int temp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = temp;

                    flag = false;
                }
            }

            // 经过上面的循环，若flag=true，表示数组中每个位置的值都小于等于其后面位置的值
            if (flag) {
                break;
            }

        }

        return in;
    }
}
