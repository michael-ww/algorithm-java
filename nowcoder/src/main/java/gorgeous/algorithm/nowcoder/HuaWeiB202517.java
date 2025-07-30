package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 拼接URL
public class HuaWeiB202517 {

    public static void main(String[] args) {
        //String input = "/acm,/bb";
        String input = "/abc/,/bcd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(",");
        parts[0] = parts[0].endsWith("/") ? parts[0] : parts[0] + "/";
        parts[1] = parts[1].startsWith("/") ? parts[1].substring(1) : parts[1];
        System.out.println(parts[0] + parts[1]);
    }
}
