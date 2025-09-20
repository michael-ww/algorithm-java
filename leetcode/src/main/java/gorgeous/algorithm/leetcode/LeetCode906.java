package gorgeous.algorithm.leetcode;

public class LeetCode906 {

    public int superpalindromesInRange(String left, String right) {
        return 0;
    }

    private static boolean isPalindrome(long num) {
        String origin = Long.toString(num);
        int left = 0, right = origin.length() - 1;
        while (left < right) {
            if (origin.charAt(left) != origin.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
