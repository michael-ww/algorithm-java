package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 游戏分组
public class HuaWeiB202523 {

    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String input = "1 2 3 4 5 6 7 8 9 10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[10];
        for (int i = 0; i < 10; i++) {
            scores[i] = scanner.nextInt();
        }
        List<Integer> selected = new ArrayList<>();
        dfs(scores, 0, selected);
        System.out.println(minDiff);
    }

    private static void dfs(int[] scores, int index, List<Integer> selected) {
        if (selected.size() == 5) {
            int diff = Math.abs(2 * selected.stream().mapToInt(Integer::intValue).sum() - Arrays.stream(scores).sum());
            minDiff = minDiff > diff ? diff : minDiff;
            return;
        }
        if (index >= scores.length) {
            return;
        }
        dfs(scores, index + 1, selected);
        selected.addLast(scores[index]);
        dfs(scores, index + 1, selected);
        selected.removeLast();
    }
}
