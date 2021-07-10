package com.patterns.ModifiedBinarySearch;

public class OrderAgnosticBS {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        return bSearch(arr, arr[0] <= arr[arr.length - 1], key);
    }

    private static int bSearch(int[] arr, boolean isAsc, int key) {
        int left = 0, right = arr.length-1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if(isAsc) {
                if(arr[mid] == key) {
                    ans = mid;
                    right = mid-1;
                } else if(arr[mid] < key) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else {
                if(arr[mid] == key) {
                    ans = mid;
                    right = mid-1;
                } else if(arr[mid] < key) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(OrderAgnosticBS.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(OrderAgnosticBS.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(OrderAgnosticBS.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(OrderAgnosticBS.search(new int[] { 10, 6, 4 }, 4));
    }

}
