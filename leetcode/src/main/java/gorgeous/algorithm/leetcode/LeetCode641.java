package gorgeous.algorithm.leetcode;

public class LeetCode641 {

    public static class MyCircularDeque {

        private final int[] data;
        private int front;
        private int rear;
        private int size;
        private final int capacity;

        public MyCircularDeque(int k) {
            this.capacity = k;
            this.data = new int[k];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        public boolean insertFront(int value) {
            if (this.isFull()) {
                return false;
            }
            this.front = (this.front - 1 + this.capacity) % this.capacity;
            this.data[this.front] = value;
            this.size++;
            return true;
        }

        // [front, rear)
        public boolean insertLast(int value) {
            if (this.isFull()) {
                return false;
            }
            this.data[this.rear] = value;
            this.rear = (this.rear + 1) % this.capacity;
            this.size++;
            return true;
        }

        public boolean deleteFront() {
            if (this.isEmpty()) {
                return false;
            }
            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return true;
        }

        public boolean deleteLast() {
            if (this.isEmpty()) {
                return false;
            }
            this.rear = (this.rear - 1 + this.capacity) % this.capacity;
            this.size--;
            return true;
        }

        public int getFront() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.data[this.front];
        }

        public int getRear() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.data[(this.rear - 1 + this.capacity) % this.capacity];
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.capacity;
        }
    }
}
