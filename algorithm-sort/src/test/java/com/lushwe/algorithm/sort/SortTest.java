package com.lushwe.algorithm.sort;

/**
 * 说明：排序算法测试
 *
 * @author Shiwei Liu
 * @date 2019-07-15 21:56
 * @since 0.1
 */
public class SortTest {

    public static void main(String[] args) {

        int[] in = {3, 2, 1, 6, 5, 4, 9, 7, 10, 8};
//        int[] in = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        Sort sort;
        sort = new BubbleSort();
        sort = new SelectionSort();
        sort = new InsertSort();

        sort.sort(in);
    }
}
