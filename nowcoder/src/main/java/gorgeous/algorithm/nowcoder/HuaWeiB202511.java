package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 货币单位换算
public class HuaWeiB202511 {

    private static final Map<String, Double> exchange;

    static {
        exchange = new HashMap<>();
        exchange.put("fen", 1.0);
        exchange.put("CNY", 100.0);
        exchange.put("JRY", 100.0 / 1825 * 100);
        exchange.put("HKD", 100.0 / 123 * 100);
        exchange.put("EUR", 100.0 / 14 * 100);
        exchange.put("GBP", 100.0 / 12 * 100);
        exchange.put("cents", 100.0 / 123);
        exchange.put("sen", 100.0 / 1825);
        exchange.put("eurocents", 100.0 / 14);
        exchange.put("pence", 100.0 / 12);
    }

    public static void main(String[] args) {
        String input = "1\n100CNY";
        // String input = "1\n3000fen";
        // String input = "1\n123HKD";
        // String input = "2\n20CNY53fen\n53HKD87cents";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double answer = 0.0;
        for (int i = 0; i < count; i++) {
            String record = scanner.next();
            int amount = 0;
            StringBuilder unit = new StringBuilder();
            for (int j = 0; j < record.length(); j++) {
                if (Character.isDigit(record.charAt(j))) {
                    amount = amount * 10 + (record.charAt(j) - '0');
                } else if (Character.isLetter(record.charAt(j))) {
                    unit.append(record.charAt(j));
                    if (j + 1 < record.length() && Character.isDigit(record.charAt(j + 1))) {
                        answer += amount * exchange.get(unit.toString());
                        amount = 0;
                        unit.setLength(0);
                    }
                }
            }
            answer += amount * exchange.get(unit.toString());
        }
        System.out.println((int) answer);
    }
}
