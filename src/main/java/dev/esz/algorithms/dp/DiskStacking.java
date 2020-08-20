package dev.esz.algorithms.dp;

import java.util.*;

public interface DiskStacking {
    // Given a non-empty list of disks (array of exactly 3 integers which represent width, depth, height)
    // stack up disk in a way to maximize the height of the stack. Important, that width, depth and height
    // of a disk should be smaller thant the one bellow it.
    // https://www.algoexpert.io/questions/Disk%20Stacking
    static List<Integer[]> solve(List<Integer[]> disks) {
        disks.sort(Comparator.comparingInt(a -> a[2]));
        List<Integer> heights = new ArrayList<>();
        List<Integer> previousDisks = new ArrayList<>();
        for (int i = 0; i < disks.size(); i++) {
            Integer[] disk = disks.get(i);
            heights.add(disk[2]);
            previousDisks.add(Integer.MIN_VALUE);
            for (int j = i - 1; j >= 0; j--) {
                Integer[] previousDisk = disks.get(j);
                if (isDiskStackable(previousDisk, disk) && heights.get(i) < disk[2] + heights.get(j)) {
                    heights.set(i, disk[2] + heights.get(j));
                    previousDisks.set(i, j);
                }
            }
        }
        int position = getMaxPosition(heights).orElseThrow();
        int previousPosition = previousDisks.get(position);
        List<Integer[]> result = new LinkedList<>();
        result.add(0, disks.get(position));
        while (previousPosition != Integer.MIN_VALUE) {
            result.add(0, disks.get(previousPosition));
            previousPosition = previousDisks.get(previousPosition);
        }
        return result;
    }

    private static boolean isDiskStackable(Integer[] previousDisk, Integer[] currentDisk) {
        return previousDisk[0] < currentDisk[0]
                && previousDisk[1] < currentDisk[1]
                && previousDisk[2] < currentDisk[2];
    }

    private static Optional<Integer> getMaxPosition(List<Integer> list) {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        int max = list.get(0);
        int position = 0;
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                position = i;
                max = list.get(i);
            }
        }
        return Optional.of(position);
    }
}
