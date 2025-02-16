package gorgeous.algorithm.leetcode;

public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int row, int column, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] == '*'
                || board[row][column] != word.charAt(index)) {
            return false;
        }
        char letter = board[row][column];
        board[row][column] = '*';
        boolean up = this.backtrack(board, row - 1, column, word, index + 1);
        boolean down = this.backtrack(board, row + 1, column, word, index + 1);
        boolean left = this.backtrack(board, row, column - 1, word, index + 1);
        boolean right = this.backtrack(board, row, column + 1, word, index + 1);
        board[row][column] = letter;
        return up || down || left || right;
    }
}
