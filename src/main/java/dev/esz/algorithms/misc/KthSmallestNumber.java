package dev.esz.algorithms.misc;

import java.util.PriorityQueue;
import java.util.Queue;

// Given an unsorted array of numbers, find Kth smallest number in it.

// Original problem: https://www.educative.io/courses/grokking-the-coding-interview/gxxPGn8vE8G
public interface KthSmallestNumber {
    static int findKthSmallestNumber(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return -1;
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
                continue;
            }
            if (heap.peek() != null && heap.peek() > num) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.size() == k ? heap.peek() : -1;
    }
}
