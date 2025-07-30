package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 查找单入口空闲区域
public class HuaWeiB202521 {

    public static void main(String[] args) {
        // String input = "4 4\nX X X X\nX O O X\nX O O X\nX O X X";
        // String input = "4 5\nX X X X X\nO O O O X\nX O O O X\n X O X X O";
        // String input = "5 4\nX X X X\nX O O O\nX O O O\nX O O X\nX X X X";
        String input = "5 4\nX X X X\nX O O O\nX X X X\nX O O O\nX X X X";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        String[][] matrix = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.next();
            }
        }

        boolean[][] visited = new boolean[row][column];
        List<int[]> regions = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ("O".equals(matrix[i][j]) && !visited[i][j]) {
                    List<int[]> exits = new ArrayList<>();
                    int count = dfs(matrix, i, j, visited, exits);
                    if (exits.size() == 1) {
                        regions.add(new int[]{exits.getFirst()[0], exits.getFirst()[1], count});
                    }
                }
            }
        }
        if (regions.size() <= 0) {
            System.out.println("NULL");
        } else {
            regions.sort((a, b) -> b[2] - a[2]);
            if (regions.size() == 1 || regions.get(0)[2] > regions.get(1)[2]) {
                System.out.println(regions.get(0)[0] + " " + regions.get(0)[1] + " " + regions.get(0)[2]);
            } else {
                System.out.println(regions.get(0)[2]);
            }
        }

    }

    private static int dfs(String[][] matrix, int row, int column, boolean[][] visited, List<int[]> exits) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[row].length || visited[row][column] || !matrix[row][column].equals("O")) {
            return 0;
        }
        visited[row][column] = true;
        if (row == 0 || row == matrix.length - 1 || column == 0 || column == matrix[row].length - 1) {
            exits.add(new int[]{row, column});
        }
        return 1 + dfs(matrix, row - 1, column, visited, exits) + dfs(matrix, row + 1, column, visited, exits) + dfs(matrix, row, column - 1, visited, exits) + dfs(matrix, row, column + 1, visited, exits);
    }
}
