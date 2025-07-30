package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.ListNode;

public class LeetCode622 {

    public static class MyCircularQueue<T extends Comparable<T>> {

        private ListNode<T> head;

        private ListNode<T> tail;

        private final int capacity;

        private int size;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.size = 0;

        }

        public boolean enQueue(T value) {
            if (this.isFull()) {
                return false;
            }
            ListNode<T> node = new ListNode<>(value);
            if (this.head == null) {
                this.head = this.tail = node;
            } else {
                this.tail.setNext(node);
                this.tail = this.tail.getNext();
            }
            this.size++;
            return true;
        }

        public T deQueue() {
            if (this.isEmpty()) {
                return null;
            }
            ListNode<T> node = this.head;
            this.head = this.head.getNext();
            this.size--;
            return node.getValue();
        }

        public T Front() {
            if (this.isEmpty()) {
                return null;
            }
            return this.head.getValue();
        }

        public T Rear() {
            if (this.isEmpty()) {
                return null;
            }
            return this.tail.getValue();
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.capacity;
        }
    }
}
