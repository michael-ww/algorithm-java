package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode567 {

    public boolean checkInclusion(String target, String source) {
        if (target == null || source == null || target.length() > source.length()) {
            return false;
        }

        if (target.isBlank() || target.isEmpty()) {
            return true;
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : target.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        for (int leftIndex = 0, rightIndex = 0, valid = 0; rightIndex < source.length(); rightIndex++) {
            char adding = source.charAt(rightIndex);
            if (need.containsKey(adding)) {
                window.put(adding, window.getOrDefault(adding, 0) + 1);
                if (need.get(adding).equals(window.get(adding))) {
                    valid++;
                }
            }
            while (rightIndex - leftIndex + 1 >= target.length()) {
                if (valid >= need.size()) {
                    return true;
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

        return false;
    }
}
