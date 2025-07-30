package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 最大数字
public class HuaWeiB202513 {

    public static void main(String[] args) {
        //String input = "34533";
        String input = "5445795045";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        int[] used = new int[10];
        int[] unused = new int[10];
        for (char c : numbers.toCharArray()) {
            unused[c - '0']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (used[c - '0'] >= 2) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < c && unused[stack.peek() - '0'] + used[stack.peek() - '0'] > 2) {
                char pop = stack.pop();
                used[pop - '0']--;
                //unused[pop - '0']++;
            }
            stack.push(c);
            unused[c - '0']--;
            used[c - '0']++;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.println(result.reverse().toString());
    }
}
