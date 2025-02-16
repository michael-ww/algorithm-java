package gorgeous.algorithm.leetcode;

public class LeetCode2435 {

    public int numberOfPaths1(int[][] grid, int k) {
        return this.numberOfPaths1(grid, k, 0, 0, 0);
    }

    private int numberOfPaths1(int[][] grid, int k, int xcoordinate, int ycoordinate, int sum) {
        sum += grid[xcoordinate][ycoordinate];
        if (xcoordinate == grid.length - 1 && ycoordinate == grid[0].length - 1) {
            return sum % k == 0 ? 1 : 0;
        }
        int answer = 0;
        if (ycoordinate + 1 < grid[0].length) {
            answer = this.numberOfPaths1(grid, k, xcoordinate, ycoordinate + 1, sum);
        }
        if (xcoordinate + 1 < grid.length) {
            answer += this.numberOfPaths1(grid, k, xcoordinate + 1, ycoordinate, sum);
        }
        return answer % 1000000007;
    }

    public int numberOfPaths2(int[][] grid, int k) {
        return this.numberOfPaths2(grid, k, 0, 0, 0);
    }

    private int numberOfPaths2(int[][] grid, int k, int xcoordinate, int ycoordinate, int remainder) {
        if (xcoordinate == grid.length - 1 && ycoordinate == grid[0].length - 1) {
            return grid[xcoordinate][ycoordinate] % k == remainder ? 1 : 0;
        }
        remainder = (k + remainder - (grid[xcoordinate][ycoordinate] % k)) % k;
        int answer = 0;
        if (ycoordinate + 1 < grid[0].length) {
            answer = this.numberOfPaths2(grid, k, xcoordinate, ycoordinate + 1, remainder);
        }
        if (xcoordinate + 1 < grid.length) {
            answer += this.numberOfPaths2(grid, k, xcoordinate + 1, ycoordinate, remainder);
        }
        return answer % 1000000007;
    }

    public int numberOfPaths3(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int r = 0; r < k; r++) {
                    dp[i][j][r] = -1;
                }
            }
        }
        return this.numberOfPaths3(grid, k, 0, 0, 0, dp);
    }

    private int numberOfPaths3(int[][] grid, int k, int xcoordinate, int ycoordinate, int remainder, int[][][] dp) {
        if (xcoordinate == grid.length - 1 && ycoordinate == grid[0].length - 1) {
            return grid[xcoordinate][ycoordinate] % k == remainder ? 1 : 0;
        }
        if (dp[xcoordinate][ycoordinate][remainder] != -1) {
            return dp[xcoordinate][ycoordinate][remainder];
        }
        remainder = (k + remainder - (grid[xcoordinate][ycoordinate] % k)) % k;
        int answer = 0;
        if (xcoordinate + 1 < grid.length) {
            answer = this.numberOfPaths3(grid, k, xcoordinate + 1, ycoordinate, remainder, dp);
        }
        if (ycoordinate + 1 < grid[0].length) {
            answer = (answer + this.numberOfPaths3(grid, k, xcoordinate, ycoordinate + 1, remainder, dp)) % 1000000007;
        }
        dp[xcoordinate][ycoordinate][remainder] = answer;
        return answer;
    }

    public int numberOfPaths4(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        dp[n - 1][m - 1][grid[n - 1][m - 1] % k] = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int r = 0; r < k; r++) {
                dp[i][m - 1][r] = dp[i + 1][m - 1][(k + r - grid[i][m - 1] % k) % k];
            }
        }
        for (int j = m - 2; j >= 0; j--) {
            for (int r = 0; r < k; r++) {
                dp[n - 1][j][r] = dp[n - 1][j + 1][(k + r - grid[n - 1][j] % k) % k];
            }
        }
        for (int i = n - 2, remainder; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                for (int r = 0; r < k; r++) {
                    remainder = (k + r - grid[i][j] % k) % k;
                    dp[i][j][r] = (dp[i + 1][j][remainder] + dp[i][j + 1][r]) % 1000000007;
                }
            }
        }
        return dp[0][0][0];
    }
}
