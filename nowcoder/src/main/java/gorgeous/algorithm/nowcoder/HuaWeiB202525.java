package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 事件推送
public class HuaWeiB202525 {

    public static void main(String[] args) {
        String input = "4 5 5\n1 5 5 10\n1 3 8 8 20";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int R = scanner.nextInt();
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = scanner.nextInt();
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        List<int[]> answer = new ArrayList<>();
        for (int indexA = 0, indexB = 0; indexA < m; indexA++) {
            while (indexB < n && A[indexA] > B[indexB]) {
                indexB++;
            }
            if (indexB >= n) {
                break;
            }
            if (B[indexB] - A[indexA] <= R) {
                answer.add(new int[]{A[indexA], B[indexB]});
            }
        }
        for (int[] item : answer) {
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
