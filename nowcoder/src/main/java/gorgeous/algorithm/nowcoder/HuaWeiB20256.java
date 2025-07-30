package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 恢复数字序列
public class HuaWeiB20256 {

    public static void main(String[] args) {
        // String sample = "19801211 5";
        String sample = "432111111111 4";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int length = scanner.nextInt();
        Map<Character, Integer> base = new HashMap<>();
        for (char c : input.toCharArray()) {
            base.put(c, base.getOrDefault(c, 0) + 1);
        }

        for (int start = 1; start <= 1000; start++) {
            int end = start + length - 1;
            if (end > 1000) {
                break;
            }
            StringBuilder sequence = new StringBuilder();
            for (int num = start; num <= end; num++) {
                sequence.append(num);
            }
            if (sequence.length() != input.length()) {
                continue;
            }
            Map<Character, Integer> candiate = new HashMap<>();
            for (char c : sequence.toString().toCharArray()) {
                candiate.put(c, candiate.getOrDefault(c, 0) + 1);
            }

            if (base.size() != candiate.size()) {
                continue;
            }
            boolean isMatched = true;
            for (Map.Entry<Character, Integer> entry : candiate.entrySet()) {
                if (!base.containsKey(entry.getKey()) || !base.get(entry.getKey()).equals(entry.getValue())) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched) {
                System.out.println(start);
                break;
            }
        }
    }
}
