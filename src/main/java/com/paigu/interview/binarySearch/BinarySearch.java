package com.paigu.interview.binarySearch;

/**
 * @author PaiGu
 * @description TODO
 * @date 2022/4/3 22:07
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 8, 9, 11, 12, 13, 13, 20, 31, 33};
        System.out.println(binarySearch(arr, 13));
    }

    public static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > value) {
                high = mid + 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
//            int mid = (low + high) / 2;
//            if (arr[mid] == value) {
//                return mid;
//            } else if (arr[mid] > value) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
        }
        return -1;
    }
}
