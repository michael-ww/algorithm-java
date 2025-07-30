package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 光伏场地建设规划
public class HuaWeiB20254 {

    public static void main(String[] args) {
        String sample = "2 5 2 6\n1 3 4 5 8\n2 3 6 7 1";
        // String sample = "2 5 1 6\n1 3 4 5 8\n2 3 6 7 1";
        // String sample = "2 5 1 0\n1 3 4 5 8\n2 3 6 7 1";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        int square = scanner.nextInt();
        int capacity = scanner.nextInt();

        int[][] matrix = new int[length][width];
        int[][] preSum = new int[length + 1][width + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + matrix[i][j];
            }
        }

        int count = 0;
        for (int row = square; row <= length; row++) {
            for (int column = square; column <= width; column++) {
                if (preSum[row][column] - preSum[row - square][column] - preSum[row][column - square] + preSum[row - square][column - square] >= capacity) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
