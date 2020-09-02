package com.lushwe.algorithm.sort;

/**
 * 说明：快速排序
 *
 * @author Jack Liu
 * @date 2020-06-08 13:22
 * @since 0.1
 */
public class QuickSort extends AbstractArraySort {

    /**
     * 快速排序
     * <p>
     * 首先把数组分成两个部分，一部分比另一部分小，再使用递归，分别在两个部分使用快速排序
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param in
     * @return
     */
    @Override
    protected int[] doSort(int[] in) {
        sort(in, 0, in.length - 1);
        return in;
    }


    private void sort(int[] in, int low, int high) {
        if (low < high) {
            int index = getIndex(in, low, high);
            sort(in, low, index - 1);
            sort(in, index + 1, high);
        }
    }

    private int getIndex(int[] in, int low, int high) {

        int temp = in[low];
        while (low < high) {

            while (low < high && temp <= in[high]) {
                high--;
            }
            in[low] = in[high];

            while (low < high && in[low] <= temp) {
                low++;
            }
            in[high] = in[low];
        }

        in[low] = temp;

        return low;
    }
}
