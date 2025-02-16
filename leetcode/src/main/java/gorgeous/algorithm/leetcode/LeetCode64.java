package gorgeous.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode64 {

    public int minPathSum1(int[][] grid) {
        if (grid == null) {
            throw new NullPointerException();
        }
        return this.minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSum(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        int up = Integer.MAX_VALUE;
        if (i > 0) {
            up = this.minPathSum(grid, i - 1, j);
        }
        int left = Integer.MAX_VALUE;
        if (j > 0) {
            left = this.minPathSum(grid, i, j - 1);
        }

        return grid[i][j] + Math.min(up, left);
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null) {
            throw new NullPointerException();
        }
        int[][] dp = new int[grid.length][grid[0].length];
        Arrays.fill(dp, -1);
        return this.minPathSum(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    private int minPathSum(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        Integer up = Integer.MAX_VALUE;
        if (i > 0) {
            up = this.minPathSum(grid, i - 1, j, dp);
        }
        Integer left = Integer.MAX_VALUE;
        if (j > 0) {
            left = this.minPathSum(grid, i, j - 1, dp);
        }
        int answer = grid[i][j] + Math.min(up, left);
        dp[i][j] = answer;
        return answer;
    }

    public int minPathSum3(int[][] grid) {
        if (grid == null) {
            throw new NullPointerException();
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum4(int[][] grid) {
        if (grid == null) {
            throw new NullPointerException();
        }
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[0][0];
                } else if (i == 0 && j != 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else if (i != 0 && j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
