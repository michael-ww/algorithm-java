package gorgeous.algorithm.leetcode;

public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length <= 0) {
            return 0;
        }

        int answer = nums[0];
        for (int i = 1, previous = nums[0]; i < nums.length; i++) {
            previous = Math.max(nums[i], previous + nums[i]);
            answer = Math.max(answer, previous);
        }
        return answer;
    }

    public int[] maxSubArrayEx(int[] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (nums.length <= 0) {
            return null;
        }

        int[] answer = new int[3];
        for (int l = 0, r = 0, previous = Integer.MIN_VALUE; r < nums.length; r++) {
            if (previous >= 0) {
                previous += nums[r];
            } else {
                previous = nums[r];
                l = r;
            }
            if (previous > answer[2]) {
                answer[0] = l;
                answer[1] = r;
                answer[2] = previous;
            }
        }

        return answer;
    }
}
