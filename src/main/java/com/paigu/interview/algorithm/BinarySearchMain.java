package com.paigu.interview.algorithm;

/**
 * 二分查找
 *
 * @author PaiGu
 * @date 2023/01/27
 */
public class BinarySearchMain {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{3, 4, 5, 6, 7, 8, 9, 22, 24, 30, 31, 66}, 2));
        System.out.println(binarySearch(new int[]{3, 4, 5, 6, 7, 8, 9, 22, 24, 30, 31, 66}, 6));
        System.out.println(binarySearch(new int[]{3}, 3));
        System.out.println(binarySearch(new int[]{3, 4, 5, 6}, 4));
        System.out.println(binarySearch(new int[]{}, 2));
        System.out.println(binarySearch(null, 2));
    }

    public static int binarySearch(int array[], int num) {
        if (array == null || array.length == 0) return -1;

        int start = 0;
        int end = array.length - 1;

        while (start != end) {
            int middle = start + (end - start) / 2;

            if (array[middle] >= num) {
                if (start == middle) return middle;
                else
                if (array[middle - 1] < num) return middle;
                else end = middle -1;

            } else {
                start = middle + 1;
            }
        }
        //start == end
        if (array[start] >= num) {
            return start;
        } else {
            return -1;
        }
    }
}
