package gorgeous.algorithm.leetcode;

public class LeetCode209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int length = Integer.MAX_VALUE, sum = 0;
        for (int leftIndex = 0, rightIndex = 0; rightIndex < nums.length; rightIndex++) {
            sum += nums[rightIndex];
            while (sum >= target) {
                length = Math.min(rightIndex - leftIndex + 1, length);
                sum -= nums[leftIndex++];
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
