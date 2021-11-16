package com.paigu.interview.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author PaiGu
 * @description 冒泡排序
 * @date 2021/11/6 17:37
 */
public class BubbleSort {
	public static void main(String[] args){
		int[] array = {2, -30, 4, 5, 77, 31, 1, 0, 1, 100, 3, 10};
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
