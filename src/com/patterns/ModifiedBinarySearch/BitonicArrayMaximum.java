package com.patterns.ModifiedBinarySearch;

public class BitonicArrayMaximum {

    public static int findMax(int[] arr) {
        int left = 0, right = arr.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[mid+1]) {
                right = mid;
            } else {
                left=mid+1;
            }
        }

        return arr[left];
    }

    public static void main(String[] args) {
        System.out.println(BitonicArrayMaximum.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(BitonicArrayMaximum.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(BitonicArrayMaximum.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(BitonicArrayMaximum.findMax(new int[] { 10, 9, 8 }));
    }

}
