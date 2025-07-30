package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 欢乐的周末
public class HuaWeiB202535 {

    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        // String input = "4 4\n2 1 0 3\n0 1 2 1\n0 3 0 0\n0 0 0 0";
        String input = "4 4\n2 1 2 3\n0 1 0 0\n0 1 0 0\n0 1 0 0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] grid = new int[row][column];
        List<int[]> starts = new ArrayList<>();
        List<int[]> destinations = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = scanner.nextInt();
                if (grid[i][j] == 2) {
                    starts.add(new int[]{i, j});
                }
                if (grid[i][j] == 3) {
                    destinations.add(new int[]{i, j});
                }
            }
        }

        // UnionFindSet ufs = new UnionFindSet(row * column);
        // for (int i = 0; i < row; i++) {
        //     for (int j = 0; j < column; j++) {
        //         if (grid[i][j] != 1) {
        //             for (int[] direction : directions) {
        //                 int x = i + direction[0];
        //                 int y = j + direction[1];
        //                 if (x >= 0 && x < row && y >= 0 && y < column && grid[x][y] != 1) {
        //                     ufs.union(i * column + j, x * column + y);
        //                 }
        //             }
        //         }
        //     }
        // }

        // int huaFather = ufs.find(starts.getFirst()[0] * column + starts.getFirst()[1]);
        // int weiFather = ufs.find(starts.getLast()[0] * column + starts.getLast()[1]);

        // if (huaFather != weiFather) {
        //     System.out.print(0);
        //     return;
        // }

        int result = 0;
        for (int[] dest : destinations) {
            if (isReachable(grid, starts.get(0)[0], starts.get(0)[1], dest[0], dest[1], new boolean[grid.length][grid[0].length]) && isReachable(grid, starts.get(1)[0], starts.get(1)[1], dest[0], dest[1], new boolean[grid.length][grid[0].length])) {
                result++;
            }
            // if (ufs.find(dest[0] * column + dest[1]) == huaFather) {
            //     result++;
            // }
        }
        System.out.println(result);
    }

    private static boolean isReachable(int[][] grid, int currentX, int currentY, int destinationX, int destinationY, boolean[][] visited) {
        if (currentX < 0 || currentY < 0 || currentX >= grid.length || currentY >= grid[0].length || grid[currentX][currentY] == 1 || visited[currentX][currentY]) {
            return false;
        }
        if (currentX == destinationX && currentY == destinationY) {
            return true;
        }
        visited[currentX][currentY] = true;
        return isReachable(grid, currentX - 1, currentY, destinationX, destinationY, visited)
                || isReachable(grid, currentX + 1, currentY, destinationX, destinationY, visited)
                || isReachable(grid, currentX, currentY - 1, destinationX, destinationY, visited)
                || isReachable(grid, currentX, currentY + 1, destinationX, destinationY, visited);
    }
}
