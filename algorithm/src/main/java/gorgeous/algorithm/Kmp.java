package gorgeous.algorithm;

public class Kmp {

    public static int process(String text, String pattern) {
        if (text == null || pattern == null || text.isEmpty() || pattern.isEmpty()) {
            return -1;
        }

        int[] next = getNext(pattern);
        int textIndex = 0, patternIndex = 0;
        while (textIndex < text.length() && patternIndex < pattern.length()) {
            if (patternIndex < 0 || text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            } else {
                patternIndex = next[patternIndex];
            }
        }

        return patternIndex == pattern.length() ? textIndex - pattern.length() : -1;
    }

    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int nextIndex = 0, comparedIndex = -1;
        while (nextIndex < pattern.length() - 1) {
            if (comparedIndex < 0 || pattern.charAt(nextIndex) == pattern.charAt(comparedIndex)) {
                next[++nextIndex] = ++comparedIndex;
            } else {
                comparedIndex = next[comparedIndex];
            }
        }

        return next;
    }
}
