package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode438 {

    public List<Integer> findAnagrams(String source, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (source == null || pattern == null || source.isBlank() || source.isEmpty() || pattern.isBlank() || pattern.isEmpty() || source.length() < pattern.length()) {
            return result;
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
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
            while (rightIndex - leftIndex + 1 >= pattern.length()) {
                if (valid >= need.size()) {
                    result.add(leftIndex);
                }
                char removing = source.charAt(leftIndex++);
                if (need.containsKey(removing)) {
                    if (need.get(removing).equals(window.get(removing))) {
                        valid--;
                    }
                    window.put(removing, window.get(removing) - 1);
                }
            }
        }

        return result;
    }
}
