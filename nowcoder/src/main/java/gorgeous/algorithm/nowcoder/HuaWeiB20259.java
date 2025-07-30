package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

// 英文输入法
public class HuaWeiB20259 {

    public static void main(String[] args) {
        String input = "I love you\nHe";
        // String input = "The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don’t know that I love you.\nf";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().replaceAll("[^a-zA-Z]", " ").split(" ");
        String prefix = scanner.nextLine();
        Set<String> wordSet = new TreeSet<>();
        wordSet.addAll(Arrays.asList(words));

        StringJoiner sj = new StringJoiner(" ");
        for (String word : wordSet) {
            if (word.startsWith(prefix)) {
                sj.add(word);
            }
        }
        if (sj.length() <= 0) {
            System.out.println(prefix);
        } else {
            System.out.println(sj.toString());
        }
    }
}
