package gorgeous.algorithm.leetcode;

public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return this.backtrack(obstacleGrid, 0, 0);
    }

    private int backtrack(int[][] obstacleGrid, int i, int j) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        obstacleGrid[i][j] = 1;
        int answer = this.backtrack(obstacleGrid, i + 1, j);
        answer += this.backtrack(obstacleGrid, i, j + 1);
        obstacleGrid[i][j] = 0;
        return answer;
    }
}
