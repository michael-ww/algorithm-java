package gorgeous.algorithm.leetcode;

public class LeetCode688 {

    public double knightProbability1(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k <= 0) {
            return 1;
        }
        double answer = this.knightProbability1(n, k - 1, row - 1, column - 2) / 8;
        answer += this.knightProbability1(n, k - 1, row - 2, column - 1) / 8;
        answer += this.knightProbability1(n, k - 1, row - 2, column + 1) / 8;
        answer += this.knightProbability1(n, k - 1, row - 1, column + 2) / 8;
        answer += this.knightProbability1(n, k - 1, row + 1, column + 2) / 8;
        answer += this.knightProbability1(n, k - 1, row + 2, column + 1) / 8;
        answer += this.knightProbability1(n, k - 1, row + 2, column - 1) / 8;
        answer += this.knightProbability1(n, k - 1, row + 1, column - 2) / 8;

        return answer;
    }

    public double knightProbability2(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int i = 0; i <= k; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    dp[i][r][c] = -1;
                }
            }
        }
        return this.knightProbability2(n, k, row, column, dp);
    }

    private double knightProbability2(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k <= 0) {
            return 1;
        }
        if (dp[k][row][column] != -1) {
            return dp[k][row][column];
        }
        double answer = this.knightProbability2(n, k - 1, row - 1, column - 2, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row - 2, column - 1, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row - 2, column + 1, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row - 1, column + 2, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row + 1, column + 2, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row + 2, column + 1, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row + 2, column - 1, dp) / 8;
        answer += this.knightProbability2(n, k - 1, row + 1, column - 2, dp) / 8;

        return answer;
    }

    public double knightProbability3(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        int[][] codinates = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        for (int step = 0; step <= k; step++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (step == 0) {
                        dp[step][r][c] = 1;
                    } else {
                        for (int[] codinate : codinates) {
                            int nr = codinate[0] + r, nc = codinate[1] + c;
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                dp[step][r][c] += dp[step - 1][nr][nc] / 8;
                            }
                        }
                    }
                }
            }
        }

        return dp[k][row][column];
    }
}
