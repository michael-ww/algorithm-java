package gorgeous.algorithm.leetcode;

public class LeetCode5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = GetPalindrome(s, i, i);
            String even = GetPalindrome(s, i, i + 1);
            result = odd.length() > result.length() ? odd : result;
            result = even.length() > result.length() ? even : result;
        }

        return result;
    }

    private String GetPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
