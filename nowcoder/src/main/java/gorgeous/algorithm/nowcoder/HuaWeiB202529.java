package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

// 荒岛求生
public class HuaWeiB202529 {

    public static void main(String[] args) {
        String input = "5 10 8 -8 -5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int[] survivors = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int item : survivors) {
            if (item >= 0) {
                stack.add(item);
            } else {
                int left = item;
                while (!stack.isEmpty()) {
                    left += stack.pop();
                    if (left > 0) {
                        stack.add(left);
                    }
                }
                if (left < 0) {
                    count++;
                }
            }
        }

        System.out.println(count + stack.size());
    }
}
