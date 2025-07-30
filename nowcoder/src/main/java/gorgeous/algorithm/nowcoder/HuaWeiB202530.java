package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 数组组成的最小数字
public class HuaWeiB202530 {

    public static void main(String[] args) {
        // String input = "21,30,62,5,31";
        String input = "5,21";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(",");
        List<String> list = Arrays.stream(numbers).sorted((a, b) -> Integer.parseInt(a) - Integer.parseInt(b)).limit(Math.min(3, numbers.length)).sorted((a, b) -> (a + b).compareTo(b + a)).collect(Collectors.toList());
        System.out.println(String.join("", list));
    }
}
