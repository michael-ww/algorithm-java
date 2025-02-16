package gorgeous.algorithm.leetcode;

import java.util.Stack;

public class LeetCode232 {

    public static class MyQueue<T> {

        private final Stack<T> inStack;
        private final Stack<T> outStack;

        public MyQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        public void push(T x) {
            this.inStack.push(x);
            this.inToOut();
        }

        public T pop() {
            this.inToOut();
            return this.outStack.pop();
        }

        public T peek() {
            this.inToOut();
            return this.outStack.peek();
        }

        public boolean empty() {
            return this.inStack.isEmpty() && this.outStack.isEmpty();
        }

        private void inToOut() {
            if (this.outStack.size() <= 0) {
                while (!this.inStack.isEmpty()) {
                    this.outStack.push(this.inStack.pop());
                }
            }
        }
    }
}
