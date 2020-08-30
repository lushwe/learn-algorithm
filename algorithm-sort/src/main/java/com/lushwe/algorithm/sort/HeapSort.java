package com.lushwe.algorithm.sort;

import java.util.Arrays;

/**
 * 说明：堆排序
 *
 * @author Jack Liu
 * @date 2020-08-30 17:18
 * @since 0.1
 */
public class HeapSort extends AbstractArraySort {

    @Override
    protected int[] doSort(int[] in) {

        // 构建大顶堆
        for (int i = in.length / 2; i >= 0; i--) {
            downAdjust(in, i, in.length);
        }

        System.out.println("大顶堆: " + Arrays.toString(in));

        for (int i = in.length - 1; i > 0; i--) {
            int temp = in[i];
            in[i] = in[0];
            in[0] = temp;
            downAdjust(in, 0, i);
        }

        return in;
    }


    private void downAdjust(int[] arr, int parentIndex, int length) {
        int childIndex = 2 * parentIndex + 1;
        int temp = arr[parentIndex];
        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            }
            if (temp >= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = temp;
    }
}
