package gorgeous.algorithm.leetcode;

public class LeetCode1143 {

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text1.isBlank() || text2 == null || text2.isBlank()) {
            return 0;
        }
        return this.recurring(text1, text2, text1.length(), text2.length());
    }

    private int recurring(String text1, String text2, int length1, int length2) {
        if (length1 <= 0 || length2 <= 0) {
            return 0;
        }
        if (text1.charAt(length1 - 1) == text2.charAt(length2 - 1)) {
            return this.recurring(text1, text2, length1 - 1, length2 - 1) + 1;
        } else {
            return Math.max(this.recurring(text1, text2, length1 - 1, length2),
                    this.recurring(text1, text2, length1, length2 - 1));
        }
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text1.isBlank() || text2 == null || text2.isBlank()) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return this.recurring(text1, text2, text1.length(), text2.length(), dp);
    }

    private int recurring(String text1, String text2, int length1, int length2, int[][] dp) {
        if (length1 <= 0 || length2 <= 0) {
            return 0;
        }
        if (dp[length1][length2] != -1) {
            return dp[length1][length2];
        }
        int answer = 0;
        if (text1.charAt(length1 - 1) == text2.charAt(length2 - 1)) {
            answer = this.recurring(text1, text2, length1 - 1, length2 - 1) + 1;
        } else {
            answer = Math.max(this.recurring(text1, text2, length1 - 1, length2),
                    this.recurring(text1, text2, length1, length2 - 1));
        }
        dp[length1][length2] = answer;
        return answer;
    }

    public int longestCommonSubsequence3(String text1, String text2) {
        if (text1 == null || text1.isBlank() || text2 == null || text2.isBlank()) {
            return 0;
        }

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence4(String text1, String text2) {
        if (text1 == null || text1.isBlank() || text2 == null || text2.isBlank()) {
            return 0;
        }
        if (text1.length() < text2.length()) {
            return this.longestCommonSubsequence4(text2, text1);
        }
        int[] dp = new int[text2.length() + 1];
        for (int i = 0, leftUp = 0, backup = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                backup = dp[j];
                if (i == 0 || j == 0) {
                    dp[j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[j] = leftUp + 1;
                    } else {
                        dp[j] = Math.max(dp[j - 1], dp[j]);
                    }
                }
                leftUp = backup;
            }
        }

        return dp[text2.length()];
    }
}
