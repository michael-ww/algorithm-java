package gorgeous.algorithm.leetcode;

public class LeetCode474 {

    public int findMaxForm1(String[] strs, int m, int n) {
        if (strs == null || strs.length <= 0 || m < 0 || n < 0) {
            return 0;
        }
        return this.findMaxForm(strs, 0, m, n);
    }

    private int findMaxForm(String[] strs, int index, int zeros, int ones) {
        if (index >= strs.length) {
            return 0;
        }

        int notSelected = this.findMaxForm(strs, index + 1, zeros, ones);
        ZeroOne zo = new ZeroOne(strs[index]);
        int selected = 0;
        if (zo.getZeros() <= zeros && zo.getOnes() <= ones) {
            selected = 1 + this.findMaxForm(strs, index + 1, zeros - zo.getZeros(), ones - zo.getOnes());
        }

        return Math.max(notSelected, selected);
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        if (strs == null || strs.length <= 0 || m < 0 || n < 0) {
            return 0;
        }
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return this.findMaxForm(strs, 0, m, n, dp);
    }

    private int findMaxForm(String[] strs, int index, int zeros, int ones, int[][][] dp) {
        if (index >= strs.length) {
            return 0;
        }
        if (dp[index][zeros][ones] != -1) {
            return dp[index][zeros][ones];
        }

        int notSelected = this.findMaxForm(strs, index + 1, zeros, ones, dp);
        ZeroOne zo = new ZeroOne(strs[index]);
        int selected = 0;
        if (zo.getZeros() <= zeros && zo.getOnes() <= ones) {
            selected = 1 + this.findMaxForm(strs, index + 1, zeros - zo.getZeros(), ones - zo.getOnes(), dp);
        }

        int answer = Math.max(notSelected, selected);
        dp[index][zeros][ones] = answer;
        return answer;
    }

    public int findMaxForm3(String[] strs, int zeros, int ones) {
        if (strs == null || strs.length <= 0 || zeros < 0 || ones < 0) {
            return 0;
        }

        int[][][] dp = new int[strs.length + 1][zeros + 1][ones + 1];
        for (int i = strs.length - 1; i >= 0; i--) {
            ZeroOne zo = new ZeroOne(strs[i]);
            for (int j = 0; j <= zeros; j++) {
                for (int k = 0; k <= ones; k++) {
                    int skiped = dp[i + 1][j][k];
                    int chosen = 0;
                    if (zo.getZeros() <= j && zo.getOnes() <= k) {
                        chosen = Math.max(dp[i + 1][j][k], 1 + dp[i + 1][j - zo.getZeros()][k - zo.getOnes()]);
                    }
                    dp[i][j][k] = Math.max(skiped, chosen);
                }
            }
        }

        return dp[0][zeros][ones];
    }

    public int findMaxForm4(String[] strs, int zeros, int ones) {
        if (strs == null || strs.length <= 0 || zeros < 0 || ones < 0) {
            return 0;
        }

        int[][] dp = new int[zeros + 1][ones + 1];
        for (int i = strs.length - 1; i >= 0; i--) {
            ZeroOne zo = new ZeroOne(strs[i]);
            for (int j = zeros; j >= zo.getZeros(); j--) {
                for (int k = ones; k >= zo.getOnes(); k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zo.getZeros()][k - zo.getOnes()]);
                }
            }
        }

        return dp[zeros][ones];
    }

    public class ZeroOne {

        private int zeros;
        private int ones;

        public ZeroOne(String str) {
            if (str == null || str.length() <= 0) {
                this.zeros = 0;
                this.ones = 0;
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    this.zeros++;
                }
                if (str.charAt(i) == '1') {
                    this.ones++;
                }
            }
        }

        public int getZeros() {
            return zeros;
        }

        public int getOnes() {
            return ones;
        }

    }
}
