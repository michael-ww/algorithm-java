package gorgeous.algorithm.leetcode;

public class LeetCode115 {

    public int numDistinct1(String s, String t) {
        if (s == null || t == null) {
            throw new NullPointerException();
        }
        return this.numDistinct(s, s.length(), t, t.length());
    }

    private int numDistinct(String s, int sl, String t, int tl) {
        if (tl <= 0) {
            return 1;
        }
        if (sl <= 0) {
            return 0;
        }
        if (s.charAt(sl - 1) == t.charAt(tl - 1)) {
            return this.numDistinct(s, sl - 1, t, tl - 1) + this.numDistinct(s, sl - 1, t, tl);
        } else {
            return this.numDistinct(s, sl - 1, t, tl);
        }
    }

    public int numDistinct2(String s, String t) {
        if (s == null || t == null) {
            throw new NullPointerException();
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return this.numDistinct(s, s.length(), t, t.length(), dp);
    }

    private int numDistinct(String s, int sl, String t, int tl, int[][] dp) {
        if (dp[sl][tl] != -1) {
            return dp[sl][tl];
        }
        if (tl <= 0) {
            return 1;
        }
        if (sl <= 0) {
            return 0;
        }
        int answer = 0;
        if (s.charAt(sl - 1) == t.charAt(tl - 1)) {
            answer = this.numDistinct(s, sl - 1, t, tl - 1) + this.numDistinct(s, sl - 1, t, tl);
        } else {
            answer = this.numDistinct(s, sl - 1, t, tl);
        }
        dp[sl][tl] = answer;
        return answer;
    }

    public int numDistinct3(String s, String t) {
        if (s == null || t == null) {
            throw new NullPointerException();
        }

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0 || j > i) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    public int numDistinct4(String s, String t) {
        if (s == null || t == null) {
            throw new NullPointerException();
        }

        int[] dp = new int[t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = t.length(); j >= 0; j--) {
                if (j == 0) {
                    dp[j] = 1;
                } else if (i == 0 || j > i) {
                    dp[j] = 0;
                } else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[t.length()];
    }
}
