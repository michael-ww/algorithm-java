package gorgeous.algorithm.leetcode;

public class LeetCode130 {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean edge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (edge && board[i][j] == 'O') {
                    this.infect(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void infect(char[][] board, int row, int column) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length || board[row][column] == '1' || board[row][column] == '#') {
            return;
        }

        board[row][column] = '#';
        this.infect(board, row + 1, column);
        this.infect(board, row - 1, column);
        this.infect(board, row, column + 1);
        this.infect(board, row, column - 1);
    }
}
