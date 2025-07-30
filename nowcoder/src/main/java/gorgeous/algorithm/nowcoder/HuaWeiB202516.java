package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 字符串序列判定
public class HuaWeiB202516 {

    public static void main(String[] args) {
        // String input = "ace\nabcde";
        String input = "fgh\nabcde";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String shortString = scanner.nextLine();
        String longString = scanner.nextLine();
        int shortIndex = 0, longIndex = 0;
        while (shortIndex < shortString.length() && longIndex < longString.length()) {
            if (shortString.charAt(shortIndex) == longString.charAt(longIndex)) {
                shortIndex++;
            }
            longIndex++;
        }
        System.out.println(shortIndex == shortString.length() ? longIndex - 1 : -1);
    }
}
