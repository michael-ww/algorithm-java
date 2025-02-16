package gorgeous.algorithm.leetcode;

public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            counter[ch - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
