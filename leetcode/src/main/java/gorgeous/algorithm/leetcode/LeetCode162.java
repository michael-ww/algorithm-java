package gorgeous.algorithm.leetcode;

public class LeetCode162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
