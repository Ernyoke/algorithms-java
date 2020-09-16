package dev.esz.algorithms.graphs;

import java.util.*;
import java.util.stream.Collectors;

// There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed
// before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible
// to schedule all the tasks.

// Original problem: https://www.educative.io/courses/grokking-the-coding-interview/gxJrM9goEMr
public class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        Map<Integer, Set<Integer>> incoming = new HashMap<>();
        Map<Integer, Set<Integer>> outGoing = new HashMap<>();

        for (int i = 0; i < tasks; i++) {
            incoming.put(i, new HashSet<>());
            outGoing.put(i, new HashSet<>());
        }

        for (int[] pre : prerequisites) {
            outGoing.get(pre[0]).add(pre[1]);
            incoming.get(pre[1]).add(pre[0]);
        }

        boolean wasNodeRemoved = true;
        while (wasNodeRemoved) {
            List<Integer> sources = incoming.entrySet().stream()
                    .filter(pair -> pair.getValue().size() == 0)
                    .map(Map.Entry::getKey).collect(Collectors.toList());
            wasNodeRemoved = sources.size() > 0;
            for (Integer node : sources) {
                Set<Integer> sinks = outGoing.get(node);
                for (Integer sink : sinks) {
                    incoming.get(sink).remove(node);
                }
                outGoing.remove(node);
                incoming.remove(node);
            }
        }

        return incoming.size() <= 0;
    }
}
