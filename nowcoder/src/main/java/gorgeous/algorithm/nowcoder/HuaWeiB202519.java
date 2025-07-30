package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 数组组成的最小数字
public class HuaWeiB202519 {

    public static void main(String[] args) {
        // String input = "21,30,62,5,31";
        String input = "5,21";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(",");
        Arrays.sort(numbers, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        String[] subarray = Arrays.copyOfRange(numbers, 0, Math.min(3, numbers.length));
        Arrays.sort(subarray, (a, b) -> (a + b).compareTo(b + a));
        System.out.println(String.join("", subarray));
    }
}
