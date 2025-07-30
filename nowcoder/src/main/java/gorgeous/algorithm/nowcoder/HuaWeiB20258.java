package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 矩形相交的面积
public class HuaWeiB20258 {

    public static void main(String[] args) {
        String input = "1 6 4 4\n3 5 3 4\n0 3 7 3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[][] rectangles = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = scanner.nextInt();
            }
        }

        // (x, y, w, h)
        // wid = min(x1 + w1, x2 + w2, x3 + w3) - max(x1, x2, x3)
        int width = Math.min(Math.min(rectangles[0][0] + rectangles[0][2], rectangles[1][0] + rectangles[1][2]), rectangles[2][0] + rectangles[2][2]) - Math.max(Math.max(rectangles[0][0], rectangles[1][0]), rectangles[2][0]);
        // hei = min(y1, y2, y3) - max(y1 - h1, y2 - h2, y3 - h3)
        int height = Math.min(Math.min(rectangles[0][1], rectangles[1][1]), rectangles[2][1]) - Math.max(Math.max(rectangles[0][1] - rectangles[0][3], rectangles[1][1] - rectangles[1][3]), rectangles[2][1] - rectangles[2][3]);
        if (width <= 0 || height <= 0) {
            System.out.println(0);
        } else {
            System.out.println(width * height);
        }
    }
}
