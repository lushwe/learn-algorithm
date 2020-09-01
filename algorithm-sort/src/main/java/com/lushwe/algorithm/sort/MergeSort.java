package com.lushwe.algorithm.sort;

/**
 * 说明：归并排序
 *
 * @author Jack Liu
 * @date 2020-08-30 17:17
 * @since 0.1
 */
public class MergeSort extends AbstractArraySort {

    @Override
    protected int[] doSort(int[] in) {
        doSort(in, new int[in.length], 0, in.length - 1);
        return in;
    }


    /**
     * 归并排序
     * <p>
     * 将数组不断拆分，然后分别排序，最后合并（分治思想）
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param in
     * @param out
     * @param start
     * @param end
     */
    private void doSort(int[] in, int[] out, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (end - start) / 2 + start;

        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        doSort(in, out, start1, end1);
        doSort(in, out, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            out[k++] = in[start1] <= in[start2] ? in[start1++] : in[start2++];
        }
        while (start1 <= end1) {
            out[k++] = in[start1++];
        }
        while (start2 <= end2) {
            out[k++] = in[start2++];
        }

        for (int i = start; i <= end; i++) {
            in[i] = out[i];
        }
    }
}
