package gorgeous.algorithm.leetcode;

public class LeetCode87 {

    public boolean isScramble1(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new NullPointerException();
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        return this.isScramble1(s1, s2, 0, 0, s1.length());
    }

    private boolean isScramble1(String s1, String s2, int l1, int l2, int length) {
        if (length == 1) {
            return s1.charAt(l1) == s2.charAt(l2);
        }
        for (int k = 1; k < length; k++) {
            if (this.isScramble1(s1, s2, l1, l2, k) && this.isScramble1(s1, s2, l1 + k, l2 + k, length - k)) {
                return true;
            }
        }
        for (int i = l1 + 1, j = l2 + length - 1, k = 1; k < length; i++, j--, k++) {
            if (this.isScramble1(s1, s2, l1, j, k) && this.isScramble1(s1, s2, i, l2, length - k)) {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new NullPointerException();
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[][][] dp = new int[s1.length()][s2.length()][s1.length() + 1];
        return this.isScramble2(s1, s2, 0, 0, s1.length(), dp);
    }

    private boolean isScramble2(String s1, String s2, int l1, int l2, int length, int[][][] dp) {
        if (length == 1) {
            return s1.charAt(l1) == s2.charAt(l2);
        }
        if (dp[l1][l2][length] != 0) {
            return dp[l1][l2][length] == 1;
        }
        boolean answer = false;
        for (int k = 1; k < length; k++) {
            if (this.isScramble1(s1, s2, l1, l2, k) && this.isScramble1(s1, s2, l1 + k, l2 + k, length - k)) {
                answer = true;
                break;
            }
        }
        if (!answer) {
            for (int i = l1 + 1, j = l2 + length - 1, k = 1; k < length; i++, j--, k++) {
                if (this.isScramble1(s1, s2, l1, j, k) && this.isScramble1(s1, s2, i, l2, length - k)) {
                    answer = true;
                    break;
                }
            }
        }
        dp[l1][l2][length] = answer == true ? 1 : -1;
        return answer;
    }

    public boolean isScramble3(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new NullPointerException();
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int l1 = 0; l1 < s1.length(); l1++) {
            for (int l2 = 0; l2 < s2.length(); l2++) {
                dp[l1][l2][1] = s1.charAt(l1) == s2.charAt(l2);
            }
        }
        for (int len = 2; len <= s1.length(); len++) {
            for (int l1 = 0; l1 <= s1.length() - len; l1++) {
                for (int l2 = 0; l2 <= s2.length() - len; l2++) {
                    for (int k = 1; k < len; k++) {
                        if (dp[l1][l2][k] && dp[l1 + k][l2 + k][len - k]) {
                            dp[l1][l2][len] = true;
                            break;
                        }
                    }
                    if (!dp[l1][l2][len]) {
                        for (int i = l1 + 1, j = l2 + len - 1, k = 1; k < len; i++, j--, k++) {
                            if (dp[l1][j][k] && dp[i][l2][len - k]) {
                                dp[l1][l2][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0][s1.length()];
    }
}
