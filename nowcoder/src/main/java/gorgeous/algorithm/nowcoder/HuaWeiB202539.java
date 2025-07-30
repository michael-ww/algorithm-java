package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 区间交集
public class HuaWeiB202539 {

    public static void main(String[] args) {
        // String input = "4\n0 3\n1 3\n3 5\n3 6";
        // String input = "4\n0 3\n1 4\n4 7\n5 8";
        String input = "2\n1 2\n3 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] ranges = new int[length][2];
        for (int i = 0; i < length; i++) {
            ranges[i][0] = scanner.nextInt();
            ranges[i][1] = scanner.nextInt();
        }
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> combine = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int start1 = ranges[i][0], end1 = ranges[i][1];
            for (int j = i + 1; j < length; j++) {
                int start2 = ranges[j][0], end2 = ranges[j][1];
                if (start2 <= end1) {
                    combine.add(new int[]{start2, Math.min(end1, end2)});
                } else {
                    break;
                }
            }
        }

        if (combine.isEmpty()) {
            System.out.println("None");
            return;
        }

        combine.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int[] pre = combine.get(0);
        for (int i = 1; i < combine.size(); i++) {
            int[] cur = combine.get(i);

            if (pre[1] >= cur[0]) {
                pre[1] = Math.max(cur[1], pre[1]);
            } else {
                System.out.println(pre[0] + " " + pre[1]);
                pre = cur;
            }
        }

        System.out.println(pre[0] + " " + pre[1]);
    }
}
