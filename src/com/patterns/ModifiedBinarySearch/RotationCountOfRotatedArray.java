package com.patterns.ModifiedBinarySearch;

class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr) {
        int left = 0, right = arr.length-1;

        while (left<=right) {
            int mid = left + (right - left)/2;

            if(mid<right && arr[mid] > arr[mid+1]) {
                return mid+1;
            }
            if(mid>left && arr[mid-1] > arr[mid]) {
                return mid;
            }

            if(arr[left] < arr[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
