package gorgeous.algorithm.leetcode;

public class LeetCode137 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Integer.MIN_VALUE;
        }

        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            int remainder = total % 3;
            if (remainder != 0) {
                answer |= 1 << i;
            }
        }

        return answer;
    }
}
