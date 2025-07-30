package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

// 矩阵扩散
public class HuaWeiB202524 {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        String input = "4,4,0,0,3,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int row = numbers[0], column = numbers[1], x1 = numbers[2], y1 = numbers[3], x2 = numbers[4], y2 = numbers[5];
        int[][] matrix = new int[row][column];
        matrix[x1][y1] = 1;
        matrix[x2][y2] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x1, y1});
        queue.add(new int[]{x2, y2});
        int elapsed = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;
            for (int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                for (int[] direction : directions) {
                    int x = coordinate[0] + direction[0];
                    int y = coordinate[1] + direction[1];
                    if (x < 0 || x >= row || y < 0 || y >= column || matrix[x][y] != 0) {
                        continue;
                    }
                    matrix[x][y] = 1;
                    queue.add(new int[]{x, y});
                    spread = true;
                }
            }
            if (spread) {
                elapsed++;
            }
        }

        System.out.println(elapsed);
    }
}
