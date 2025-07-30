package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 最长的指定瑕疵度的元音子串
public class HuaWeiB202514 {

    private static final Set<Character> vowels;

    static {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('o');
        vowels.add('e');
        vowels.add('i');
        vowels.add('u');
        vowels.add('A');
        vowels.add('O');
        vowels.add('E');
        vowels.add('I');
        vowels.add('U');
    }

    public static void main(String[] args) {
        String input = "0\nasdbuiodevauufgh";
        // String input = "2\naeueo";
        // String input = "1\naabeebuu";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int flaw = scanner.nextInt();
        String string = scanner.next();
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (vowels.contains(string.charAt(i))) {
                positions.add(i);
            }
        }
        if (positions.size() < 2) {
            System.out.println(0);
        } else {
            int answer = 0;
            for (int left = 0, right = 0; right < positions.size(); right++) {
                int diff = positions.get(right) - positions.get(left) - (right - left);
                if (diff < flaw) {
                    continue;
                }
                if (diff > flaw) {
                    left++;
                    continue;
                }
                if (diff == flaw) {
                    answer = Math.max(answer, positions.get(right) - positions.get(left) + 1);
                }
            }
            System.out.println(answer);
        }
    }
}
