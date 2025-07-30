package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.Utility;

public class LeetCode31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i >= 0) {
            int k = nums.length - 1;
            while (k >= j && nums[i] >= nums[k]) {
                k--;
            }
            Utility.swap(nums, i, k);
        }
        Utility.reverse(nums, i + 1, nums.length - 1);
    }
}
