package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 流水线
public class HuaWeiB202522 {

    public static void main(String[] args) {
        String input = "3 5\n8 4 3 2 10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int tasks = scanner.nextInt();
        int[] times = new int[tasks];
        for (int i = 0; i < tasks; i++) {
            times[i] = scanner.nextInt();
        }
        Arrays.sort(times);
        int[] elapsed = new int[lines];
        for (int i = 0; i < tasks; i++) {
            elapsed[i % lines] += times[i];
        }
        System.out.println(Arrays.stream(elapsed).max());
    }
}
