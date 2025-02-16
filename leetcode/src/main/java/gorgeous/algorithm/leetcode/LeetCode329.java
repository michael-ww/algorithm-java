package gorgeous.algorithm.leetcode;

public class LeetCode329 {

    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }
        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer = Math.max(answer, this.longestIncreasingPath(matrix, i, j));
            }
        }

        return answer;
    }

    private int longestIncreasingPath(int[][] matrix, int row, int column) {
        int next = 0;
        if (row > 0 && matrix[row - 1][column] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row - 1, column));
        }
        if (row + 1 < matrix.length && matrix[row + 1][column] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row + 1, column));
        }
        if (column > 0 && matrix[row][column - 1] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row, column - 1));
        }
        if (column + 1 < matrix[0].length && matrix[row][column + 1] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row, column + 1));
        }
        return next + 1;
    }

    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer = Math.max(answer, this.longestIncreasingPath(matrix, i, j, dp));
            }
        }

        return answer;
    }

    private int longestIncreasingPath(int[][] matrix, int row, int column, int[][] dp) {
        if (dp[row][column] != 0) {
            return dp[row][column];
        }
        int next = 0;
        if (row > 0 && matrix[row - 1][column] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row - 1, column));
        }
        if (row + 1 < matrix.length && matrix[row + 1][column] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row + 1, column));
        }
        if (column > 0 && matrix[row][column - 1] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row, column - 1));
        }
        if (column + 1 < matrix[0].length && matrix[row][column + 1] > matrix[row][column]) {
            next = Math.max(next, this.longestIncreasingPath(matrix, row, column + 1));
        }
        dp[row][column] = next + 1;
        return next + 1;
    }
}
