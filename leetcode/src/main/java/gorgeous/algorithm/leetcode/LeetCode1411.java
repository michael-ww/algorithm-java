package gorgeous.algorithm.leetcode;

public class LeetCode1411 {

    public int numOfWays(int n) {
        if (n <= 0) {
            return 0;
        }
        long fi0 = 6, fi1 = 6;
        for (int i = 2; i <= n; ++i) {
            long newFi0 = (2 * fi0 + 2 * fi1) % 1000000007;
            long newFi1 = (2 * fi0 + 3 * fi1) % 1000000007;
            fi0 = newFi0;
            fi1 = newFi1;
        }
        return (int) ((fi0 + fi1) % 1000000007);
    }
}
