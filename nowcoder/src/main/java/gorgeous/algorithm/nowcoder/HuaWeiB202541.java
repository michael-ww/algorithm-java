package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.StringJoiner;

// 最小循环子数组
public class HuaWeiB202541 {

    public static void main(String[] args) {
        String input = "9\n1 2 1 1 2 1 1 2 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] next = getNext(numbers);
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < length - next[length]; i++) {
            sj.add(String.valueOf(numbers[i]));
        }
        System.out.println(sj.toString());
    }

    private static int[] getNext(int[] numbers) {
        int[] next = new int[numbers.length + 1];
        next[0] = -1;
        int nextIndex = 0, comparedIndex = -1;
        while (nextIndex < numbers.length) {
            if (comparedIndex == -1 || numbers[nextIndex] == numbers[comparedIndex]) {
                next[++nextIndex] = ++comparedIndex;
            } else {
                comparedIndex = next[comparedIndex];
            }
        }
        return next;
    }
}
