package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 任务总执行时长
public class HuaWeiB202526 {

    public static void main(String[] args) {
        String input = "1,2,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] tasks = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> elapsed = new TreeSet<>();
        for (int i = 0; i <= tasks[2]; i++) {
            elapsed.add(tasks[0] * i + tasks[1] * (tasks[2] - i));
        }
        System.out.println(elapsed.toString());
    }
}
