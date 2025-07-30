package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 字符串分割
public class HuaWeiB202515 {

    public static void main(String[] args) {
        // String input = "3\n12abc-abCABc-4aB@";
        String input = "12\n12abc-abCABc-4aB@";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[] parts = scanner.next().split("-");
        StringBuilder result = new StringBuilder(parts[0]);
        if (parts.length == 1) {
            System.out.println(result.toString());
            return;
        }
        StringBuilder remaining = new StringBuilder();
        for (int i = 1; i < parts.length; i++) {
            remaining.append(parts[i]);
        }
        String remainingString = remaining.toString();
        List<String> newParts = new ArrayList<>();
        for (int i = 0; i < remainingString.length(); i += length) {
            int end = Math.min(i + length, remainingString.length());
            String part = remainingString.substring(i, end);
            newParts.add(convertCase(part));
        }
        if (!newParts.isEmpty()) {
            result.append("-").append(String.join("-", newParts));
        }
        System.out.println(result.toString());
    }

    private static String convertCase(String s) {
        int lowerCount = 0;
        int upperCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCount++;
            } else if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        if (lowerCount > upperCount) {
            return s.toLowerCase();
        } else if (upperCount > lowerCount) {
            return s.toUpperCase();
        } else {
            return s;
        }
    }
}
