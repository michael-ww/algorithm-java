package gorgeous.algorithm.leetcode;

public class LeetCode509 {

    public int fib(int n) {
        int pprevious = 0, previous = 1;
        for (int current = 2; current <= n; current++) {
            current = pprevious + previous;
            pprevious = previous;
            previous = current;
        }
        return previous;
    }
}
