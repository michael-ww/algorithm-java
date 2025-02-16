package gorgeous.algorithm.leetcode;

public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        return this.backtrack(new int[m][n], 0, 0);
    }

    private int backtrack(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        grid[i][j] = 1;
        int answer = this.backtrack(grid, i + 1, j);
        answer += this.backtrack(grid, i, j + 1);
        grid[i][j] = 0;
        return answer;
    }
}
