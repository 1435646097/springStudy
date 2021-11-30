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
	public static void main(String[] args){
		int[] arr = {2, -30, 4, 5, 77, 31, 1, 0, 1, 100, 3, 10, 31, 20, 11, 2, 2, 2};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high){
		int left = low;
		int right = high;
		int pivot = arr[(low + high) / 2];
		while (left < right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left == right) {
				break;
			}
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			if (arr[left] == pivot) {
				right--;
			}
			if (arr[right] == pivot) {
				left++;
			}
		}
		if (left == right) {
			left++;
			right--;
		}
		if (right > low) {
			quickSort(arr, low, right);
		}
		if (left < high) {
			quickSort(arr, left, high);
		}
	}
}
