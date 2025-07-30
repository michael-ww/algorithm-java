package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 数组二叉树
public class HuaWeiB202518 {

    public static void main(String[] args) {
        // String input = "3 5 7 -1 -1 2 4";
        String input = "5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != -1 && (2 * i + 1 >= numbers.length || numbers[2 * i + 1] == -1) && (2 * i + 2 >= numbers.length || numbers[2 * i + 2] == -1) && numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        do {
            path.addFirst(numbers[minIndex]);
            minIndex = (minIndex - 1) / 2;
        } while (minIndex > 0);
        path.addFirst(numbers[0]);
        System.out.println(String.join(" ", path.stream().map(String::valueOf).toArray(String[]::new)));
    }
}
