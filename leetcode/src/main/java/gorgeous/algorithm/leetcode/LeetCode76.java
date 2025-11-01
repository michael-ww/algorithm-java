package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {

    public String minWindow(String source, String target) {
        if (source == null || target == null || source.isBlank() || source.isEmpty() || target.isBlank() || target.isEmpty() || source.length() < target.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : target.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int startIndex = 0, length = Integer.MAX_VALUE;
        for (int leftIndex = 0, rightIndex = 0, valid = 0; rightIndex < source.length(); rightIndex++) {
            char adding = source.charAt(rightIndex);
            if (need.containsKey(adding)) {
                window.put(adding, window.getOrDefault(adding, 0) + 1);
                if (need.get(adding).equals(window.get(adding))) {
                    valid++;
                }
            }
            while (valid >= need.size()) {
                if (rightIndex - leftIndex + 1 < length) {
                    startIndex = leftIndex;
                    length = rightIndex - leftIndex + 1;
                }
                char removing = source.charAt(leftIndex);
                leftIndex++;
                if (need.containsKey(removing)) {
                    if (need.get(removing).equals(window.get(removing))) {
                        valid--;
                    }
                    window.put(removing, window.get(removing) - 1);
                }
            }
        }

        return length == Integer.MAX_VALUE ? "" : source.substring(startIndex, startIndex + length);
    }
}
