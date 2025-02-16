package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode895 {

    public static class FreqStack {

        private int maxFrequency;
        private final Map<Integer, Integer> frequency;
        private final Map<Integer, Stack<Integer>> group;

        public FreqStack() {
            this.maxFrequency = 0;
            this.frequency = new HashMap<>();
            this.group = new HashMap<>();
        }

        public void push(int val) {
            this.frequency.put(val, this.frequency.getOrDefault(val, 0) + 1);
            this.group.getOrDefault(this.frequency.get(val), new Stack<>()).push(val);
            this.maxFrequency = Math.max(this.maxFrequency, this.frequency.get(val));
        }

        public int pop() {
            int val = this.group.get(this.maxFrequency).pop();
            if (this.frequency.get(val) == 1) {
                this.frequency.remove(val);
            } else {
                this.frequency.put(val, this.frequency.get(val) - 1);
            }
            if (this.group.get(this.maxFrequency).isEmpty()) {
                this.group.remove(this.maxFrequency--);
            }
            return val;
        }
    }
}
