package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 返回矩阵中非1的元素个数
public class HuaWeiB20252 {

    private static final int[][] directions;

    static {
        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    }

    public static void main(String[] args) {
        String sample = "4 4\n0 0 0 0\n0 2 2 2\n0 2 0 0\n0 2 0 0";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        matrix[0][0] = 1;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        int oneCount = 1;
        while (!stack.isEmpty()) {
            int[] one = stack.poll();
            for (int[] dir : directions) {
                int x = one[0] + dir[0];
                int y = one[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] == 0) {
                    matrix[x][y] = 1;
                    oneCount++;
                    stack.add(new int[]{x, y});
                }
            }
        }

        System.out.println(n * m - oneCount);
    }
}
