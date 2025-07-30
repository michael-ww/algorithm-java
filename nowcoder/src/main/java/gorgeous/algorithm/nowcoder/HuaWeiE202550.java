package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 斗地主之顺子
public class HuaWeiE202550 {

    private static final Map<String, Integer> cardToNumber;

    static {
        cardToNumber = new HashMap<>();
        cardToNumber.put("3", 3);
        cardToNumber.put("4", 4);
        cardToNumber.put("5", 5);
        cardToNumber.put("6", 6);
        cardToNumber.put("7", 7);
        cardToNumber.put("8", 8);
        cardToNumber.put("9", 9);
        cardToNumber.put("10", 10);
        cardToNumber.put("J", 11);
        cardToNumber.put("Q", 12);
        cardToNumber.put("K", 13);
        cardToNumber.put("A", 14);
        cardToNumber.put("2", 15);
    }

    public static void main(String[] args) {
        String input = "2 9 J 2 3 4 K A 7 9 A 5 6";
        // String input = "2 9 J 10 3 4 K A 7 Q A 5 6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        List<String> cards = Arrays.stream(scanner.nextLine().split(" ")).sorted((a, b) -> cardToNumber.get(a) - cardToNumber.get(b)).distinct().filter(a -> !a.equals("2")).toList();
        List<String> straight = new ArrayList<>();
        boolean broken = false;
        for (int i = 0; i < cards.size(); i++) {
            if (straight.size() <= 0 || cardToNumber.get(cards.get(i)) - cardToNumber.get(cards.get(i - 1)) == 1) {
                straight.add(cards.get(i));
            } else {
                broken = true;
            }
            if ((broken || i == cards.size() - 1) && straight.size() >= 5) {
                System.out.println(String.join(" ", straight));
                straight.clear();
            }
        }
    }
}
