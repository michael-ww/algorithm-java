package gorgeous.algorithm.leetcode;

class NumMatrix {

    private final int[][] previousSum;

    public NumMatrix(int[][] matrix) {
        this.previousSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < previousSum.length; i++) {
            for (int j = 1; j < previousSum[i].length; j++) {
                previousSum[i][j] = previousSum[i - 1][j] + previousSum[i][j - 1] - previousSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return previousSum[row2 + 1][col2 + 1] - previousSum[row1][col2 + 1] - previousSum[row2 + 1][col1] - previousSum[row1][col1];
    }
}
