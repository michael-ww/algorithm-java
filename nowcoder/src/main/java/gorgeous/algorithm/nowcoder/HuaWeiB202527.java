package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 增强的strstr
public class HuaWeiB202527 {

    public static void main(String[] args) {
        String input = "abcd\nb[cd]";
        // String input = "abcdefg\n[xyz]d";
        // String input = "abcdefg\ncd[e]f";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String pattern = scanner.nextLine();
        // target = target.replaceAll("\\[(.*?)\\]", "[$1]");
        // Pattern pattern = Pattern.compile(target);
        // Matcher matcher = pattern.matcher(source);
        // System.out.println(matcher.find()?matcher.start():-1);

        int sourceIndex = 0;
        boolean found = false;
        while (sourceIndex < source.length()) {
            int sIndex = sourceIndex;
            int patternIndex = 0;
            while (patternIndex < pattern.length()) {
                if (pattern.charAt(patternIndex) == '[') {
                    int pIndex = patternIndex + 1;
                    Set<Character> set = new HashSet<>();
                    while (pIndex < pattern.length() && pattern.charAt(pIndex) != ']') {
                        set.add(pattern.charAt(pIndex));
                        pIndex++;
                    }
                    if (!set.contains(source.charAt(sIndex))) {
                        break;
                    }
                    patternIndex = pIndex + 1;
                } else {
                    if (pattern.charAt(patternIndex) != source.charAt(sIndex)) {
                        break;
                    } else {
                        patternIndex++;
                    }
                }
                sIndex++;
            }
            if (patternIndex >= pattern.length()) {
                found = true;
                break;
            }
            sourceIndex++;
        }
        System.out.println(found ? sourceIndex : -1);
    }
}
