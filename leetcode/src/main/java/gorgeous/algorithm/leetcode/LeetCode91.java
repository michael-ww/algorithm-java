package gorgeous.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode91 {

    public int numDecodings1(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }
        return this.numDecodings(s, 0);
    }

    private int numDecodings(String s, int index) {
        if (index >= s.length()) {
            return 1;
        } else if (s.charAt(index) == '0') {
            return 0;
        } else {
            int answer = this.numDecodings(s, index + 1);
            if (index + 1 < s.length() && (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
                answer += this.numDecodings(s, index + 2);
            }
            return answer;
        }
    }

    public int numDecodings2(String s) {
        if (s == null || s.isBlank() || s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return this.numDecodings(s, 0, dp);
    }

    private int numDecodings(String s, int index, int[] dp) {
        if (index >= s.length()) {
            return 1;
        } else if (s.charAt(index) == '0') {
            return 0;
        } else if (dp[index] != -1) {
            return dp[index];
        } else {
            int answer = this.numDecodings(s, index + 1, dp);
            if (index + 1 < s.length() && (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
                answer += this.numDecodings(s, index + 2, dp);
            }
            dp[index] = answer;
            return answer;
        }
    }

    public int numDecodings3(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public int numDecodings4(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }

        int next = 1, nnext = 0;
        for (int i = s.length() - 1, current; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                current = 0;
            } else {
                current = next;
                if (i + 1 < s.length() && (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                    current += nnext;
                }
            }
            nnext = next;
            next = current;
        }
        return next;
    }
}
