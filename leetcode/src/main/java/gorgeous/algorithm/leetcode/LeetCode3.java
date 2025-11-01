package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {

    public String longestDistinctSubstring1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String answer = "";
        int rightIndex = 0;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                hs.remove(s.charAt(i - 1));
            }
            while (rightIndex < s.length() && !hs.contains(s.charAt(rightIndex))) {
                hs.add(s.charAt(rightIndex));
                rightIndex++;
            }
            answer = rightIndex - i > answer.length() ? s.substring(i, rightIndex) : answer;
        }

        return answer;
    }

    public String longestDistinctSubstring2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String answer = "";
        int leftIndex = 0, rightIndex = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (rightIndex < s.length()) {
            if (hm.containsKey(s.charAt(rightIndex))) {
                answer = rightIndex - leftIndex > answer.length() ? s.substring(leftIndex, rightIndex) : answer;
                leftIndex = hm.get(s.charAt(rightIndex)) + 1;
                hm.remove(s.charAt(rightIndex));
            }
            hm.put(s.charAt(rightIndex), rightIndex);
            rightIndex++;
        }

        return answer;
    }

    public String longestDistinctSubstring3(String source) {
        if (source == null || source.isBlank() || source.isEmpty()) {
            return "";
        }

        Set<Character> window = new HashSet<>();
        String result = "";
        for (int leftIndex = 0, rightIndex = 0; rightIndex < source.length(); rightIndex++) {
            char adding = source.charAt(rightIndex);
            while (window.contains(adding)) {
                window.remove(source.charAt(leftIndex++));
            }
            window.add(adding);
            if (rightIndex - leftIndex + 1 > result.length()) {
                result = source.substring(leftIndex, rightIndex + 1);
            }
        }

        return result;
    }

}
