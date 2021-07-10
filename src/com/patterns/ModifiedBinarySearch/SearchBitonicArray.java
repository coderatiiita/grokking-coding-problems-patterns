package com.patterns.ModifiedBinarySearch;

class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        int left = 0, right = arr.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == key) {
                return mid;
            } else if(arr[mid] < arr[mid+1]) {
                if(arr[mid] < key) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else {
                if(arr[mid] < key) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}