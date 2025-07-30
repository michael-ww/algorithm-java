package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// MVP争夺战
public class HuaWeiB202512 {

    public static void main(String[] args) {
        String input = "9\n5 2 1 5 2 1 5 2 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        int[] points = new int[minutes];
        for (int i = 0; i < minutes; i++) {
            points[i] = scanner.nextInt();
        }

        int total = 0, max = 0;
        for (int point : points) {
            total += point;
            max = Math.max(point, max);
        }
        int minScore = total;
        for (int np = minutes; np >= 1; np--) {
            int score = total / np;
            if (total % np != 0 || score < max) {
                continue;
            }
            if (canDistribute(points, np, score)) {
                minScore = Math.min(minScore, score);
            }
        }

        System.out.println(minScore);
    }

    private static boolean canDistribute(int[] points, int np, int score) {
        int[] players = new int[np];
        Arrays.fill(players, 0);
        return backtrack(points, 0, players, score);
    }

    private static boolean backtrack(int[] points, int index, int[] players, int score) {
        if (index >= points.length) {
            return true;
        }

        for (int i = 0; i < players.length; i++) {
            if (players[i] + points[index] <= score) {
                players[i] += points[index];
                if (backtrack(points, index + 1, players, score)) {
                    return true;
                }
                players[i] -= points[index];
            }
        }
        return false;
    }
}
