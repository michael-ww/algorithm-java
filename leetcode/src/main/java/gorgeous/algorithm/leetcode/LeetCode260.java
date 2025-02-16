package gorgeous.algorithm.leetcode;

public class LeetCode260 {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int eor1 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }

        int rightOne = eor1 & (~eor1 + 1);
        int eor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor2 ^= num;
            }
        }

        return new int[]{eor1 ^ eor2, eor2};
    }
}
