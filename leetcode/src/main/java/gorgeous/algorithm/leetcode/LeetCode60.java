package gorgeous.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode60 {

    public String getPermutation1(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            if (k % 2 == 0) {
                return "21";
            } else {
                return "12";
            }
        }
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int t = 0; t < k - 1; t++) {
            int i = array.length - 2, j = array.length - 1;
            while (i >= 0 && array[i] >= array[j]) {
                i--;
                j--;
            }
            if (i >= 0) {
                int p = array.length - 1;
                if (p >= 0 && array[i] >= array[p]) {
                    p--;
                }
                Utility.swap(array, i, p);
            }
            Utility.reverse(array, i + 1, array.length - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i);
        }
        return sb.toString();
    }

    public String getPermutation2(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuilder ans = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
