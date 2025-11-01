package gorgeous.algorithm.leetcode;

public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int oneCount = 0;
        for (int leftIndex = 0, rightIndex = 0, zeroCount = 0; rightIndex < nums.length; rightIndex++) {
            zeroCount += nums[rightIndex] == 1 ? 0 : 1;
            while (zeroCount > k) {
                if (nums[leftIndex++] == 0) {
                    zeroCount--;
                }
            }
            if (rightIndex - leftIndex + 1 > oneCount) {
                oneCount = rightIndex - leftIndex + 1;
            }
        }

        return oneCount;
    }
}
