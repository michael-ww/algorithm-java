package gorgeous.algorithm.leetcode;

public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        int leftIndex = 0, rightIndex = nums.length;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] == leftIndex + 1) {
                leftIndex++;
            } else if (nums[leftIndex] <= leftIndex || nums[leftIndex] > rightIndex
                    || nums[leftIndex] != nums[nums[leftIndex] - 1]) {
                Utility.swap(nums, leftIndex, --rightIndex);
            } else {
                Utility.swap(nums, leftIndex, nums[leftIndex] - 1);
            }
        }

        return leftIndex + 1;
    }
}
