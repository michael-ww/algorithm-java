package gorgeous.algorithm.leetcode;

public class LeetCode647 {

    public int countSubstrings(String s) {
        int answer = 0;
        if (s == null || s.length() <= 0) {
            return answer;
        }
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                answer++;
                left--;
                right++;
            }
        }
        return answer;
    }
}
