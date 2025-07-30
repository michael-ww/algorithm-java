package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 战场索敌
public class HuaWeiB202544 {

    public static void main(String[] args) {
        String input = "3 5 2\n..#EE\nE.#E.\n###..";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int limit = scanner.nextInt();
        char[][] grid = new char[row][column];
        for (int i = 0; i < row; i++) {
            String line = scanner.next();
            for (int j = 0; j < column; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        boolean[][] visited = new boolean[row][column];
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (visited[i][j] || grid[i][j] == '#') {
                    continue;
                }
                int enemyCount = infect(grid, i, j, visited);
                answer += enemyCount < limit ? 1 : 0;
            }
        }
        System.out.println(answer);
    }

    private static int infect(char[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[row].length || visited[row][column] || grid[row][column] == '#') {
            return 0;
        }
        visited[row][column] = true;
        int enemyCount = grid[row][column] == 'E' ? 1 : 0;
        return enemyCount + infect(grid, row - 1, column, visited) + infect(grid, row + 1, column, visited) + infect(grid, row, column - 1, visited) + infect(grid, row, column + 1, visited);
    }
}
