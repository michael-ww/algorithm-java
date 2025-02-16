package gorgeous.algorithm.leetcode;

public class LeetCode75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int lessIndex = -1, moreIndex = nums.length, index = 0;
        while (index < moreIndex) {
            if (nums[index] > 1) {
                Utility.swap(nums, --moreIndex, index);
            } else if (nums[index] < 1) {
                Utility.swap(nums, ++lessIndex, index++);
            } else {
                index++;
            }
        }
    }
}
