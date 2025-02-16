package gorgeous.algorithm.leetcode;

public class LeetCode200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    this.infect(grid, i, j);
                }
            }
        }

        return answer;
    }

    private void infect(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] != '1') {
            return;
        }

        grid[row][column] = 'i';
        this.infect(grid, row - 1, column);
        this.infect(grid, row + 1, column);
        this.infect(grid, row, column - 1);
        this.infect(grid, row, column + 1);
    }
}
