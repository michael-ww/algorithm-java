package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 补种未成活胡杨
public class HuaWeiB202510 {

    public static void main(String[] args) {
        // String input = "5\n2\n2 4\n1";
        String input = "10\n3\n2 4 7\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int dead = scanner.nextInt();
        int[] trees = new int[total];
        Arrays.fill(trees, 1);
        for (int i = 0; i < dead; i++) {
            trees[scanner.nextInt() - 1] = 0;
        }
        int suplement = scanner.nextInt();

        int answer = 0, need = 0;
        for (int left = 0, right = 0; right < trees.length; right++) {
            need += trees[right] == 0 ? 1 : 0;
            while (need > suplement) {
                need -= trees[left] == 0 ? 1 : 0;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        System.out.println(answer);
    }
}
