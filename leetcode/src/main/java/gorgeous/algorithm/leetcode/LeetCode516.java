package gorgeous.algorithm.leetcode;

public class LeetCode516 {

    public int longestPalindromeSubseq1(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        return this.longestPalindromeSubseq(s, 0, s.length() - 1);
    }

    private int longestPalindromeSubseq(String s, int leftIndex, int rightIndex) {
        if (leftIndex < 0 || leftIndex >= s.length() || leftIndex > rightIndex || rightIndex < 0
                || rightIndex >= s.length()) {
            return 0;
        }
        if (leftIndex == rightIndex) {
            return 1;
        }

        if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
            return this.longestPalindromeSubseq(s, leftIndex + 1, rightIndex - 1) + 2;
        } else {
            return Math.max(this.longestPalindromeSubseq(s, leftIndex + 1, rightIndex),
                    this.longestPalindromeSubseq(s, leftIndex, rightIndex - 1));
        }
    }

    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return this.longestPalindromeSubseq(s, 0, s.length() - 1, dp);
    }

    private int longestPalindromeSubseq(String s, int leftIndex, int rightIndex, int[][] dp) {
        if (leftIndex < 0 || leftIndex >= s.length() || leftIndex > rightIndex || rightIndex < 0
                || rightIndex >= s.length()) {
            return 0;
        }
        if (leftIndex == rightIndex) {
            return 1;
        }
        if (dp[leftIndex][rightIndex] != -1) {
            return dp[leftIndex][rightIndex];
        }
        int answer = 0;
        if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
            answer = this.longestPalindromeSubseq(s, leftIndex + 1, rightIndex - 1) + 2;
        } else {
            answer = Math.max(this.longestPalindromeSubseq(s, leftIndex + 1, rightIndex),
                    this.longestPalindromeSubseq(s, leftIndex, rightIndex - 1));
        }
        dp[leftIndex][rightIndex] = answer;
        return answer;
    }

    public int longestPalindromeSubseq3(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i > j) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public int longestPalindromeSubseq4(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int[] dp = new int[s.length()];
        for (int i = s.length() - 1, leftDown = 0, backup = 0; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                backup = dp[j];
                if (i == j) {
                    dp[j] = 1;
                } else if (i > j) {
                    dp[j] = 0;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j] = leftDown + 2;
                    } else {
                        dp[j] = Math.max(dp[j - 1], dp[j]);
                    }
                }
                leftDown = backup;
            }
        }

        return dp[s.length() - 1];
    }
}
