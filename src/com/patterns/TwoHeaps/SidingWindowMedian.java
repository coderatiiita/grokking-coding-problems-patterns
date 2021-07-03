package com.patterns.TwoHeaps;

import java.util.PriorityQueue;

class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public SlidingWindowMedian() {
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minHeap = new PriorityQueue<>((a,b) -> a-b);
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];

        for(int i=0; i<nums.length; i++) {
            if(maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            rebalanceHeaps();

            if(i+1 - k >= 0) {
                if(maxHeap.size() == minHeap.size()) {
                    res[i+1-k] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    res[i+1-k] = maxHeap.peek();
                }

                maxHeap.remove(nums[i+1-k]);
                minHeap.remove(nums[i+1-k]);
                rebalanceHeaps();
            }
        }

        return res;
    }

    private void rebalanceHeaps() {
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}