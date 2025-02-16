package gorgeous.algorithm.leetcode;

public class LeetCode136 {

    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }

        return eor;
    }
}
