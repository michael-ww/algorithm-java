package gorgeous.algorithm.leetcode;

public class LeetCode72 {

    public int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new NullPointerException();
        }
        return this.minDistance(word1, word1.length(), word2, word2.length(), 1, 1, 1);
    }

    private int minDistance(String word1, int length1, String word2, int length2, int insert, int delete, int replace) {
        if (length1 <= 0) {
            return length2 * insert;
        }
        if (length2 <= 0) {
            return length1 * delete;
        }
        if (word1.charAt(length1 - 1) == word2.charAt(length2 - 1)) {
            return this.minDistance(word1, length1 - 1, word2, length2 - 1, insert, delete, replace);
        } else {
            return Math.min(this.minDistance(word1, length1, word2, length2 - 1, insert, delete, replace) + insert,
                    Math.min(
                            this.minDistance(word1, length1 - 1, word2, length2 - 1, insert, delete, replace) + replace,
                            this.minDistance(word1, length1 - 1, word2, length2, insert, delete, replace) + delete));
        }
    }

    public int minDistance2(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new NullPointerException();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return this.minDistance(word1, word1.length(), word2, word2.length(), 1, 1, 1, dp);
    }

    private int minDistance(String word1, int length1, String word2, int length2, int insert, int delete, int replace,
            int[][] dp) {
        if (dp[length1][length2] != -1) {
            return dp[length1][length2];
        }
        if (length2 <= 0) {
            return length1 * insert;
        }
        if (length1 <= 0) {
            return length2 * delete;
        }
        int answer = 0;
        if (word1.charAt(length1 - 1) == word2.charAt(length2 - 1)) {
            answer = this.minDistance(word1, length1 - 1, word2, length2 - 1, insert, delete, replace);
        } else {
            answer = Math.min(this.minDistance(word1, length1, word2, length2 - 1, insert, delete, replace) + insert,
                    Math.min(
                            this.minDistance(word1, length1 - 1, word2, length2 - 1, insert, delete, replace) + replace,
                            this.minDistance(word1, length1 - 1, word2, length2, insert, delete, replace) + delete));
        }
        dp[length1][length2] = answer;
        return answer;
    }

    public int minDistance3(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new NullPointerException();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int insert = 1, delete = 1, replace = 1;
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 && j != 0) {
                    dp[i][j] = j * insert;
                } else if (i != 0 && j == 0) {
                    dp[i][j] = i * delete;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + delete,
                                Math.min(dp[i - 1][j - 1] + replace, dp[i][j - 1] + insert));
                    }
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public int minDistance4(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new NullPointerException();
        }
        if (word1.length() < word2.length()) {
            return this.minDistance4(word2, word1);
        }

        int[] dp = new int[word2.length() + 1];
        int insert = 1, delete = 1, replace = 1;
        for (int i = 0, leftUp = 0, backup = 0; i <= word1.length(); i++) {
            leftUp = i * delete;
            for (int j = 0; j <= word2.length(); j++) {
                backup = dp[j];
                if (i == 0 && j == 0) {
                    dp[j] = 0;
                } else if (i == 0 && j != 0) {
                    dp[j] = j * insert;
                } else if (i != 0 && j == 0) {
                    dp[j] = i * delete;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[j] = leftUp;
                    } else {
                        dp[j] = Math.min(leftUp + replace, Math.min(dp[j - 1] + insert, dp[j] + delete));
                    }
                }
                leftUp = backup;
            }
        }

        return dp[word2.length()];
    }
}
