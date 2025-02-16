package gorgeous.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {

    public static class MyStack<T> {

        private final Queue<T> queue;

        public MyStack() {
            this.queue = new LinkedList<>();

        }

        public void push(T x) {
            this.queue.add(x);
            for (int i = 0; i < this.queue.size() - 1; i++) {
                this.queue.add(this.queue.poll());
            }
        }

        public T pop() {
            return this.queue.poll();
        }

        public T top() {
            return this.queue.peek();
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
