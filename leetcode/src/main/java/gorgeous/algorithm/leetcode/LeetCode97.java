package gorgeous.algorithm.leetcode;

public class LeetCode97 {

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1 == null) {
            return s2.equals(s3);
        }
        if (s2 == null) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return this.isInterleave(s1, s1.length(), s2, s2.length(), s3, s3.length());
    }

    private boolean isInterleave(String s1, int length1, String s2, int length2, String s3, int length3) {
        if (length1 <= 0) {
            return s2.substring(0, length2).equals(s3.substring(0, length3));
        }
        if (length2 <= 0) {
            return s1.substring(0, length1).equals(s3.substring(0, length3));
        }

        boolean fromS1 = s1.charAt(length1 - 1) == s3.charAt(length3 - 1)
                && this.isInterleave(s1, length1 - 1, s2, length2, s3, length3 - 1);
        boolean fromS2 = s2.charAt(length2 - 1) == s3.charAt(length3 - 1)
                && this.isInterleave(s1, length1, s2, length2 - 1, s3, length3 - 1);

        return fromS1 || fromS2;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null) {
            return s2.equals(s3);
        }
        if (s2 == null) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = null;
            }
        }
        return this.isInterleave(s1, s1.length(), s2, s2.length(), s3, s3.length(), dp);
    }

    private boolean isInterleave(String s1, int length1, String s2, int length2, String s3, int length3,
            Boolean[][] dp) {
        if (dp[length1][length2] != null) {
            return dp[length1][length2];
        }
        if (length1 <= 0) {
            return s2.substring(0, length2).equals(s3.substring(0, length3));
        }
        if (length2 <= 0) {
            return s1.substring(0, length1).equals(s3.substring(0, length3));
        }

        boolean fromS1 = s1.charAt(length1 - 1) == s3.charAt(length3 - 1)
                && this.isInterleave(s1, length1 - 1, s2, length2, s3, length3 - 1);
        boolean fromS2 = s2.charAt(length2 - 1) == s3.charAt(length3 - 1)
                && this.isInterleave(s1, length1, s2, length2 - 1, s3, length3 - 1);

        boolean answer = fromS1 || fromS2;
        dp[length1][length2] = answer;
        return answer;
    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s1 == null) {
            return s2.equals(s3);
        }
        if (s2 == null) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && j != 0) {
                    dp[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
                } else if (i != 0 && j == 0) {
                    dp[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
                } else {
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                            || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave4(String s1, String s2, String s3) {
        if (s1 == null) {
            return s2.equals(s3);
        }
        if (s2 == null) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() < s2.length()) {
            return this.isInterleave4(s2, s1, s3);
        }

        boolean[] dp = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0 && j != 0) {
                    dp[j] = s2.substring(0, j).equals(s3.substring(0, j));
                } else if (i != 0 && j == 0) {
                    dp[j] = s1.substring(0, i).equals(s3.substring(0, i));
                } else {
                    dp[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j])
                            || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1]);
                }
            }
        }
        return dp[s2.length()];
    }
}
