package gorgeous.algorithm.leetcode;

public class LeetCode33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) >> 1;
            if (nums[middleIndex] == target) {
                return middleIndex;
            }
            if (nums[leftIndex] < nums[middleIndex]) {
                if (nums[leftIndex] <= target && nums[middleIndex] > target) {
                    rightIndex = middleIndex - 1;
                } else {
                    leftIndex = middleIndex + 1;
                }
            } else {
                if (nums[middleIndex] < target && nums[rightIndex] >= target) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
            }
        }
        return -1;
    }
}
