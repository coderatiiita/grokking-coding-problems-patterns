package com.patterns.ModifiedBinarySearch;

class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };

        result[0] = lBound(arr, key);
        if(result[0] != -1)
            result[1] = rBound(arr, key);

        return result;
    }

    private static int rBound(int[] arr, int key) {
        int left = 0, right = arr.length-1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == key) {
                ans = mid;
                left = mid+1;
            } else if(arr[mid] < key) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return ans;
    }

    private static int lBound(int[] arr, int key) {
        int left = 0, right = arr.length-1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == key) {
                ans = mid;
                right = mid-1;
            } else if(arr[mid] < key) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}