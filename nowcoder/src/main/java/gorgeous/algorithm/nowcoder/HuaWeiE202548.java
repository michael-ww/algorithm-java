package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 开心消消乐
public class HuaWeiE202548 {

    private static final int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        // String input = "4 4\n1 1 0 0\n0 0 0 1\n0 0 1 1\n1 1 1 1";
        String input = "3 3\n1 0 1\n0 1 0\n1 0 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] grid = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    infect(grid, i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void infect(int[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[row].length || grid[row][column] == 0) {
            return;
        }
        grid[row][column] = 0;
        for (int[] di : directions) {
            infect(grid, row + di[0], column + di[1]);
        }
    }
}
