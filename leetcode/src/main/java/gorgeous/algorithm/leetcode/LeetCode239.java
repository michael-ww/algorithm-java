package gorgeous.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode239 {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] deque = new int[100001];
        int head = 0, tail = 0;
        for (int i = 0; i < k - 1; i++) {
            while (head < tail && nums[deque[tail - 1]] <= nums[i]) {
                tail--;
            }
            deque[tail++] = i;
        }

        int[] answer = new int[nums.length - k + 1];
        for (int left = 0, right = k - 1; left < right; left++, right++) {
            while (head < tail && nums[deque[tail - 1]] <= nums[right]) {
                tail--;
            }
            deque[tail++] = right;
            answer[left] = nums[deque[head]];
            if (deque[head] == left) {
                head++;
            }
        }
        return answer;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (nums[deque.getLast()] <= nums[i] && !deque.isEmpty()) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        int[] answer = new int[nums.length - k + 1];
        for (int left = 0, right = k - 1; right < nums.length; left++, right++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[right]) {
                deque.removeLast();
            }
            deque.addLast(right);
            answer[left] = nums[deque.getFirst()];
            if (deque.getFirst() == left) {
                deque.removeFirst();
            }
        }

        return answer;
    }
}
