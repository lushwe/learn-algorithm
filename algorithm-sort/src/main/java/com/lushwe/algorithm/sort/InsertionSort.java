package com.lushwe.algorithm.sort;

/**
 * 说明：插入排序
 *
 * @author Jack Liu
 * @date 2019-05-14 15:34
 * @since 1.0
 */
public class InsertionSort extends AbstractArraySort {


    /**
     * 插入排序
     * <p>
     * 从第二个开始，和前面所有元素进行比较，选择插入位置
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param in
     * @return
     */
    @Override
    protected int[] doSort(int[] in) {

        for (int i = 1; i < in.length; i++) {

            int temp = in[i];

            int j = i;

            while (j > 0 && temp < in[j - 1]) {

                in[j] = in[j - 1];

                j--;
            }

            if (j != i) {
                in[j] = temp;
            }
        }

        return in;
    }
}
