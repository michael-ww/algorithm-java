package gorgeous.algorithm.leetcode;

public class LeetCode231 {

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && n == (n & (~n + 1));
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
