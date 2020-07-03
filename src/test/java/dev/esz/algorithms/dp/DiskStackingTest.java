package dev.esz.algorithms.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DiskStackingTest {
    @Test
    @DisplayName("should return the disk stack with the maximum height")
    void diskStackingTest() {
        Integer[] i = new Integer[]{1, 2, 3};
        List<Integer[]> disk = new ArrayList<>(List.of(
                new Integer[]{2, 1, 2},
                new Integer[]{3, 2, 3},
                new Integer[]{2, 2, 8},
                new Integer[]{2, 3, 4},
                new Integer[]{1, 3, 1},
                new Integer[]{4, 4, 5}
        ));
        List<Integer[]> result = DiskStacking.solve(disk);
        assertThat(result).containsExactly(new Integer[]{2, 1, 2}, new Integer[]{3, 2, 3}, new Integer[]{4, 4, 5});
        result.forEach(res -> System.out.println(Arrays.toString(res)));
    }

    @Test
    @DisplayName("should return the disk stack with one disk")
    void diskStackingOneDiskStack() {
        List<Integer[]> disk = new ArrayList<>() {{
            add(new Integer[]{2, 1, 2});
        }};
        List<Integer[]> result = DiskStacking.solve(disk);
        assertThat(result).containsExactly(new Integer[]{2, 1, 2});
    }

}
