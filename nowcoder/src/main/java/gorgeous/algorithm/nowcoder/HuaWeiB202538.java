package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 士兵过河
public class HuaWeiB202538 {

    public static void main(String[] args) {
        // String input = "5\n43\n12 13 15 20 50";
        // String input = "5\n130\n50 12 13 15 20";
        String input = "7\n171\n25 12 13 15 20 35 20";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int limit = scanner.nextInt();
        int[] elapsed = new int[count];
        for (int i = 0; i < count; i++) {
            elapsed[i] = scanner.nextInt();
        }
        Arrays.sort(elapsed);
        int[] dp = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            switch (i) {
                case 1 ->
                    dp[1] = elapsed[0];
                case 2 ->
                    dp[2] = elapsed[1];
                default ->
                    dp[i] = Math.min(dp[i - 1] + elapsed[i - 1] + elapsed[0], dp[i - 2] + elapsed[0] + elapsed[i - 1] + elapsed[1] + elapsed[1]);
            }

            if (dp[i] > limit) {
                System.out.println(i - 1 + " " + dp[i - 1]);
                break;
            }
            if (i == count) {
                System.out.println(i + " " + dp[i]);
            }
        }
    }
}
