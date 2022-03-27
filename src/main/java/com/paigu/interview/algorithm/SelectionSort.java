package com.paigu.interview.algorithm;

/**
 * @author PaiGu
 * @description 选择排序
 * @date 2021/11/27 10:26
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {2, -30, 4, 5, 77, 31, 1, 0, 1, 100, 3, 10, 31, 20, 11, 2, 2, 2};
		selectSort(arr);
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void selectSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = minIndex + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
