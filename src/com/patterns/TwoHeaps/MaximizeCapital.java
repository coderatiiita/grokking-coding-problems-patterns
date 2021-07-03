package com.patterns.TwoHeaps;

import java.util.*;

class MaximizeCapital {
    static class Node {
        int capital;
        int profit;
        int idx;

        public Node(int idx, int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
            this.idx = idx;
        }
    }

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.capital-b.capital);
        for(int i=0; i<capital.length; i++) {
            minHeap.offer(new Node(i, capital[i], profits[i]));
        }

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a,b) -> b.profit - a.profit);

        for(int i=0; i<numberOfProjects; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().capital <= initialCapital) {
                maxHeap.offer(minHeap.poll());
            }
            if(maxHeap.isEmpty()) {
                break;
            }
            initialCapital = initialCapital + maxHeap.peek().profit;
            maxHeap.poll();
        }

        return initialCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
