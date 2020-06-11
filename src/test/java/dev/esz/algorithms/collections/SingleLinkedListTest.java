package dev.esz.algorithms.collections;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

import static org.assertj.core.api.Assertions.assertThat;

class SingleLinkedListTest {

    @Test
    void reverse() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        List<Integer> expected = List.of(6, 5, 4, 3, 2, 1);

        singleLinkedList.reverse();

        Iterator<Integer> it = singleLinkedList.iterator();
        for (int i = 0; i < expected.size() && it.hasNext(); i++) {
            assertThat(it.next()).isEqualTo(expected.get(i));
        }
    }
}
