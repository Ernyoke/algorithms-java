package dev.esz.algorithms.collections;

import java.util.*;
import java.util.function.Consumer;

public class SingleLinkedList<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ListNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for (E e : this) {
            action.accept(e);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return new Spliterator<E>() {
            private ListNode<E> current = head;
            long remainingSize = size;

            @Override
            public boolean tryAdvance(Consumer<? super E> action) {
                if (action == null) {
                    throw new NullPointerException();
                }
                if (current == null || current.next == null) {
                    return false;
                }
                action.accept(current.value);
                remainingSize--;
                return true;
            }

            @Override
            public Spliterator<E> trySplit() {
                List<E> list = new ArrayList<>();
                while (current.next != null) {
                    list.add(current.value);
                    current = current.next;
                    remainingSize--;
                }
                return Spliterators.spliterator(list, ORDERED);
            }

            @Override
            public long estimateSize() {
                return remainingSize;
            }

            @Override
            public int characteristics() {
                return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
            }
        };
    }

    public static class ListNode<E> {
        private final E value;
        private ListNode<E> next;

        public ListNode(final E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setNext(final ListNode<E> next) {
            this.next = next;
        }

        public ListNode<E> getNext() {
            return next;
        }
    }

    private ListNode<E> head;
    private ListNode<E> tail;
    private long size = 0;

    public void add(final E value) {
        if (head == null) {
            this.tail = this.head = new ListNode<>(value);
        } else {
            tail.next = new ListNode<>(value);
            tail = tail.next;
        }
        size++;
    }

    public long getSize() {
        return size;
    }

    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }
        ListNode<E> previous = head;
        ListNode<E> current = head.next;
        head.next = null;

        while (current != null) {
            ListNode<E> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        tail = head;
        head = previous;
    }

}
