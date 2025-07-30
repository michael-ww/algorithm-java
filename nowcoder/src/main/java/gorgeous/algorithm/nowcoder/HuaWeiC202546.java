package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 构成指定长度字符串的个数
public class HuaWeiC202546 {

    public static void main(String[] args) {
        String input = "abc 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        Arrays.sort(chars);
        int limit = scanner.nextInt();
        System.out.println(backtrack(chars, limit, '#'));
    }

    private static int backtrack(char[] chars, int limit, char previous) {
        if (limit == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                if ((i > 0 && chars[i] == chars[i - 1]) || chars[i] == previous) {
                    continue;
                }
                char temp = chars[i];
                chars[i] = '#';
                count += backtrack(chars, limit - 1, chars[i]);
                chars[i] = temp;
            }
        }
        return count;
    }
}
