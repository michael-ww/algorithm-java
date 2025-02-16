package gorgeous.algorithm.leetcode;

public class LeetCode198 {

    public int rob1(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length <= 0) {
            return 0;
        }
        return this.rob1(nums, 0);
    }

    private int rob1(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[nums.length - 1];
        }
        if (index == nums.length - 2) {
            return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        }
        int robbing = 0, notRobbing = 0;
        if (index + 1 < nums.length) {
            notRobbing = this.rob1(nums, index + 1);
        }
        if (index + 2 < nums.length) {
            robbing = nums[index] + this.rob1(nums, index + 2);
        }
        return Math.max(robbing, notRobbing);
    }

    public int rob2(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        return this.rob2(nums, nums.length);
    }

    private int rob2(int[] nums, int length) {
        if (length <= 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int robbing = 0, notRobbing = 0;
        if (length - 1 > 0) {
            notRobbing = this.rob2(nums, length - 1);
        }
        if (length - 2 > 0) {
            robbing = nums[length - 1] + this.rob2(nums, length - 2);
        }
        return Math.max(robbing, notRobbing);
    }

    public int rob3(int[] nums) {
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
        int pprevious = nums[0], previous = Math.max(nums[0], nums[1]);
        for (int i = 2, current; i < nums.length; i++) {
            current = Math.max(previous, nums[i] + pprevious);
            pprevious = previous;
            previous = current;
        }
        return previous;
    }
}
