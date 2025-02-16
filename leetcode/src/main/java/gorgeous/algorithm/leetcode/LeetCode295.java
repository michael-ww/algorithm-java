package gorgeous.algorithm.leetcode;

import java.util.PriorityQueue;

public class LeetCode295 {

    public static class MedianFinder {

        private final PriorityQueue<Integer> bigRootHeap;
        private final PriorityQueue<Integer> smallRootHeap;

        public MedianFinder() {
            this.bigRootHeap = new PriorityQueue<>((a, b) -> b - a);
            this.smallRootHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (this.bigRootHeap.isEmpty() || this.bigRootHeap.peek() >= num) {
                this.bigRootHeap.add(num);
            } else {
                this.smallRootHeap.add(num);
            }
            this.balance();
        }

        public double findMedian() {
            if (this.bigRootHeap.size() == this.smallRootHeap.size()) {
                return (this.bigRootHeap.peek() + this.smallRootHeap.peek()) / 2d;
            } else {
                return this.bigRootHeap.size() > this.smallRootHeap.size() ? this.bigRootHeap.peek()
                        : this.smallRootHeap.peek();
            }
        }

        private void balance() {
            while (Math.abs(this.bigRootHeap.size() - this.smallRootHeap.size()) > 1) {
                if (this.bigRootHeap.size() > this.smallRootHeap.size()) {
                    this.smallRootHeap.add(this.bigRootHeap.poll());
                } else {
                    this.bigRootHeap.add(this.smallRootHeap.poll());
                }
            }
        }
    }
}
