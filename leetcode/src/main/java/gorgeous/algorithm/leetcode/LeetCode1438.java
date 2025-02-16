package gorgeous.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1438 {

    public int longestSubarray(int[] nums, int limit) {
        int result = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        for (int left = 0, right = 0; left < nums.length; left++) {
            while (right < nums.length) {
                while (!maxQueue.isEmpty() && nums[right] > nums[maxQueue.peekLast()]) {
                    maxQueue.pollLast();
                }
                maxQueue.offerLast(right);
                while (!minQueue.isEmpty() && nums[right] < nums[minQueue.peekLast()]) {
                    minQueue.pollLast();
                }
                minQueue.offerLast(right);
                if (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit) {
                    break;
                }
                right++;
            }
            result = Math.max(result, right - left);
            if (maxQueue.peekFirst() == left) {
                maxQueue.pollFirst();
            }
            if (minQueue.peekFirst() == left) {
                minQueue.pollFirst();
            }
        }

        return result;
    }
}
