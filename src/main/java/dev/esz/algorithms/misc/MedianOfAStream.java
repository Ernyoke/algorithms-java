package dev.esz.algorithms.misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Design a class to calculate the median of a number stream. The class should have the following two methods:

 * insertNum(int num): stores the number in the class
 * findMedian(): returns the median of all numbers inserted in the class
 * If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
 */

// Original problem: https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4
public class MedianOfAStream {
    private Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());
    private Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    private void reBalanceHeaps() {
        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.offer(minHeap.poll());
        }

        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public void insertNum(int num) {
        Integer upperMid = minHeap.peek();
        if (upperMid != null) {
            if (upperMid > num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else {
            minHeap.offer(num);
        }

        reBalanceHeaps();
    }

    public double findMedian() {
        if (maxHeap.size() > 0 && minHeap.size() > 0) {
            if (maxHeap.size() == minHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        } else {
            if (minHeap.size() > 0) {
                return minHeap.peek();
            }
        }
        return -1;
    }
}
