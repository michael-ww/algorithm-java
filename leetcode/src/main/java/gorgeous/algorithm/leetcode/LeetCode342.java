package gorgeous.algorithm.leetcode;

public class LeetCode342 {

    public boolean isPowerOfFour1(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
