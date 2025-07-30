package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 贪吃的猴子
public class HuaWeiB202532 {

    public static void main(String[] args) {
        // String input = "7\n1 2 2 7 3 6 1\n3";
        // String input ="3\n1 2 3\n3";
        String input = "4\n4 2 2 3\n2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int count = scanner.nextInt();
        int sum = Arrays.stream(numbers, 0, count).sum();
        int left = count - 1, right = length - 1, answer = sum;
        while (left >= 0) {
            sum += numbers[right--] - numbers[left--];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
