package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;

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
}
