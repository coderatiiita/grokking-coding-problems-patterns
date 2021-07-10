package com.patterns.ModifiedBinarySearch;

class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        // TODO: Write your code here
        int left = 0, right = arr.length-1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] >= key) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
