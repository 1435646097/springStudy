package com.paigu.interview.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author PaiGu
 * @description PaiGu
 * @date 2021/11/6 17:41
 */
public class QuickSort {
	public static void main(String[] args){
		int[] arr = {2, -30, 4, 5, 77, 31, 1, 0, 1, 100, 3, 10};
		quickSort(arr, arr.length - 1, 0);
		System.out.println(Arrays.toString(arr));
	}


	private static void quickSort(int[] arr, int high, int low){
		int l = low;
		int r = high;
		int pivot = arr[(l + r) / 2];
		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}
			if (l >= r) {
				break;
			}
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}
		}
		if (l == r) {
			l++;
			r--;
		}
		if (l < high) {
			quickSort(arr, high, l);
		}
		if (low < r) {
			quickSort(arr, r, low);
		}
	}
}
