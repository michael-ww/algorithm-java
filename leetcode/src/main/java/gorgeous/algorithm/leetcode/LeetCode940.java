package gorgeous.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode940 {

    public int distinctSubseqII(String s) {
        Set<String> set = new HashSet<>();
        this.distinctSubseqII(s, 0, new StringBuilder(), set);
        return set.size();
    }

    private void distinctSubseqII(String s, int index, StringBuilder path, Set<String> set) {
        if (index == s.length()) {
            if (!path.isEmpty()) {
                set.add(path.toString());
            }
        } else {
            path.append(s.charAt(index));
            this.distinctSubseqII(s, index + 1, path, set);
            path.deleteCharAt(path.length() - 1);
            this.distinctSubseqII(s, index + 1, path, set);
        }
    }
}
