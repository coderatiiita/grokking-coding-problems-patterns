package com.patterns.TwoHeaps;

import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        PriorityQueue<Integer> maxStart = new PriorityQueue<>((a, b) -> intervals[b].start - intervals[a].start);
        PriorityQueue<Integer> maxEnd = new PriorityQueue<>((a,b) -> intervals[b].end - intervals[a].end);

        for(int i=0; i<intervals.length; i++) {
            maxStart.offer(i);
            maxEnd.offer(i);
        }

        for(int i=0; i<intervals.length; i++) {
            int topEnd = maxEnd.poll();
            int topStart = -1;
            while(intervals[maxStart.peek()].start >= intervals[topEnd].end) {
                topStart = maxStart.poll();
            }
            result[topEnd] = topStart;
            if(topStart != -1) {
                maxStart.offer(topStart);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}