package gorgeous.algorithm.leetcode;

public class LeetCode918 {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length <= 0) {
            return 0;
        }
        int all = nums[0], maxSum = nums[0], minSum = nums[0];
        for (int i = 1, previousMaxSum = nums[0], previousMinSum = nums[0]; i < nums.length; i++) {
            all += nums[i];
            previousMaxSum = Math.max(nums[i], nums[i] + previousMaxSum);
            maxSum = Math.max(maxSum, previousMaxSum);
            previousMinSum = Math.min(nums[i], nums[i] + previousMinSum);
            minSum = Math.min(maxSum, previousMinSum);
        }

        return all == minSum ? maxSum : Math.max(maxSum, all - minSum);
    }
}
