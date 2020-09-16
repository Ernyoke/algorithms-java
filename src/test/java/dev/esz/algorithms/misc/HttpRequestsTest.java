package dev.esz.algorithms.misc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HttpRequestsTest {

    @Test
    void solutionTest1() {
        int[] A = new int[] {1, 3, 4, 2, 2, 2, 1, 1, 2};
        assertThat(new HttpRequests().solution(A)).isTrue();
    }
}
