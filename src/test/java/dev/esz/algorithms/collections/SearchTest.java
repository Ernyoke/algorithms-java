package dev.esz.algorithms.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    @DisplayName("should return the nth element")
    void quickSelect() {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 6, 5, 7, 9, 8, -1, 2, 1));
        assertThat(Search.quickSelect(list, 3).orElseThrow()).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the nth element")
    void quickSelect2() {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 6, 5, 7, 9, 8, -1, 2, 1));
        assertThat(Search.quickSelect(list, 5).orElseThrow()).isEqualTo(4);
    }

    @Test
    @DisplayName("should return the nth element")
    void quickSelect3() {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 6, 5, 7, 9, 8, -1, 2, 1));
        assertThat(Search.quickSelect(list, 8).orElseThrow()).isEqualTo(7);
    }

    @Test
    @DisplayName("should return the greatest element")
    void quickSelect4() {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 6, 5, 7, 9, 8, -1, 2, 1));
        assertThat(Search.quickSelect(list, 10).orElseThrow()).isEqualTo(9);
    }

    @Test
    @DisplayName("should return the lowest element")
    void quickSelect5() {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 6, 5, 7, 9, 8, -1, 2, 1));
        assertThat(Search.quickSelect(list, 0).orElseThrow()).isEqualTo(-1);
    }

    @Test
    @DisplayName("should return the nth element")
    void quickSelect6() {
        List<Integer> list = new ArrayList<>(List.of(1, 4, 3, 6, 5, 7, 9, 8, -1, 2, 1));
        assertThat(Search.quickSelect(list, 15)).isEmpty();
    }

    @Test
    @DisplayName("should return the second element in a small list")
    void quickSelect7() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        assertThat(Search.quickSelect(list, 1).orElseThrow()).isEqualTo(2);
    }

    @Test
    @DisplayName("should return the first element in a small list")
    void quickSelect8() {
        List<Integer> list = new ArrayList<>(List.of(2, 1));
        assertThat(Search.quickSelect(list, 0).orElseThrow()).isEqualTo(1);
    }

    @Test
    @DisplayName("should find first position for the predicate")
    public void linearSearchPredicateTest() {
        assertThat(Search.linearSearch(List.of(-1, -1, -2, 3, -2), item -> item > 0).orElseThrow()).isEqualTo(3);
    }

    @Test
    @DisplayName("should not find any position for the predicate")
    public void linearSearchPredicateEmptyResultTest() {
        assertThat(Search.linearSearch(List.of(-1, -1, -2, 3, -2), item -> item > 10).isEmpty()).isTrue();
    }

    @Test
    @DisplayName("should find first position for the element")
    public void findEmptyPositionIfTest() {
        assertThat(Search.linearSearch(3, List.of(-1, -1, -2, 3, -2)).orElseThrow()).isEqualTo(3);
    }
}
