package com.lushwe.algorithm;

/**
 * 说明：合并两个有序数组
 *
 * @author Jack Liu
 * @date 2020-06-08 10:19
 * @since 0.1
 */
public class SortedArrayMerge {

    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7, 9, 11, 13};
        int[] b = {2, 4, 6, 8, 10, 12};

        int[] c = mergeTwo(a, b);

        for (int k = 0; k < c.length; k++) {
            System.out.println("c[" + k + "] = " + c[k]);
        }

    }

    public static int[] mergeTwo(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);

        int index1 = a.length - 1;
        int index2 = b.length - 1;
        int index = c.length - 1;

        while (index2 >= 0) {
            if (index1 >= 0 && a[index1] >= b[index2]) {
                c[index--] = a[index1--];
            } else {
                c[index--] = b[index2--];
            }
        }
        return c;
    }

    public static int[] merge(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        for (int k = 0; k < c.length; k++) {
            if (i < a.length && j < b.length) {
                if (a[i] <= b[j]) {
                    c[k] = a[i++];
                } else {
                    c[k] = b[j++];
                }
            } else if (i < a.length) {
                c[k] = a[i++];
            } else if (j < b.length) {
                c[k] = b[j++];
            }
        }
        return c;
    }
}
