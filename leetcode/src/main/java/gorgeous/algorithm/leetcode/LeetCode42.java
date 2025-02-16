package gorgeous.algorithm.leetcode;

import java.util.Stack;

public class LeetCode42 {

    public int trap1(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int answer = 0;
        for (int i = 0; i < height.length; i++) {
            answer += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return answer;
    }

    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int index = stack.pop();
                if (!stack.isEmpty()) {
                    answer += (Math.min(height[i], height[stack.peek()]) - height[index]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return answer;
    }

    public int trap3(int[] height) {
        int answer = 0, leftIndex = 0, rightIndex = height.length - 1, leftMax = height[0],
                rightMax = height[height.length - 1];
        while (leftIndex < rightIndex) {
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);
            if (height[leftIndex] < height[rightIndex]) {
                answer += leftMax - height[leftIndex++];
            } else {
                answer += rightMax - height[rightIndex--];
            }
        }
        return answer;
    }
}
