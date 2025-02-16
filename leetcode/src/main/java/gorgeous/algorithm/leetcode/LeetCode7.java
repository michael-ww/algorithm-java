package gorgeous.algorithm.leetcode;

public class LeetCode7 {

    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        int reversed = 0;
        while (x != 0) {
            if (reversed < Integer.MIN_VALUE / 10 || reversed > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }
}
