package com.patterns.ModifiedBinarySearch;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

class SearchInfiniteSortedArray {

    public static int search(ArrayReader reader, int key) {
        int size=1;
        int left=0, right=0;

        while(reader.get(right) < key) {
            size = 2*size;
            left = right+1;
            right = left + size - 1;
        }

        while (left <= right) {
            int mid = left + (right-left)/2;
            if(reader.get(mid) == key) {
                return mid;
            } else if(reader.get(mid) < key) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}