package gorgeous.algorithm.leetcode;

public class LeetCode213 {

    public int rob1(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(this.rob1(nums, 2, nums.length - 2) + nums[0], this.rob1(nums, 1, nums.length - 1));
    }

    private int rob1(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int robbing = 0, notRobbing = 0;
        if (left + 2 < right) {
            robbing = nums[left] + this.rob1(nums, left + 2, right);
        }
        if (left + 1 < right) {
            notRobbing = this.rob1(nums, left + 1, right);
        }
        return Math.max(robbing, notRobbing);
    }

    public int rob2(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(nums[0] + this.rob2(nums, 2, nums.length - 2), this.rob2(nums, 1, nums.length - 1));
    }

    private int rob2(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int pprevious = nums[left], previous = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2, current; i < right; i++) {
            current = Math.max(previous, nums[i] + Math.max(0, pprevious));
            pprevious = previous;
            previous = current;
        }
        return previous;
    }
}
