package gorgeous.algorithm.leetcode;

import java.util.Stack;

public class LeetCode155 {

    public static class MinStack<T extends Comparable<T>> {

        private final Stack<T> data;
        private final Stack<T> min;

        public MinStack() {
            this.data = new Stack<>();
            this.min = new Stack<>();
        }

        public void push(T val) {
            if (min.isEmpty() || val.compareTo(min.peek()) <= 0) {
                this.min.push(val);
            } else {
                this.min.push(min.peek());
            }
            this.data.push(val);
        }

        public T pop() {
            if (this.data.isEmpty()) {
                return null;
            }
            this.min.pop();
            return this.data.pop();
        }

        public T top() {
            return this.data.isEmpty() ? null : this.data.peek();
        }

        public T getMin() {
            return this.min.isEmpty() ? null : this.min.peek();
        }
    }
}
