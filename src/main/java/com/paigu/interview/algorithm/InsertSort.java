package com.paigu.interview.algorithm;

/**
 * 插入排序
 *
 * @author PaiGu
 * @description 插入排序实现
 * @date 2022/3/26 21:04
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {2, -30, 4, 5, 77, 31, 1, 0, 1, 100, 3, 10};
        InsertSort.insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }
}
