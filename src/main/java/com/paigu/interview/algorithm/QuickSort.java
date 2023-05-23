package com.paigu.interview.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author PaiGu
 * @description 快速排序
 * @date 2021/11/6 17:41
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 20, 3};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序
     *
     * @param arr   数组
     * @param start 开始
     * @param end   结束
     */
    private static void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 1 || start >= end) {
            return;
        }
        int pivotIndex = partition(arr, start, end);
        sort(arr, start, pivotIndex - 1);
        sort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
                continue;
            }
            if (arr[j] >= pivot) {
                j--;
                continue;
            }
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }

    /**
     * 交换位置
     *
     * @param array 数组
     * @param i     index1
     * @param j     index2
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

