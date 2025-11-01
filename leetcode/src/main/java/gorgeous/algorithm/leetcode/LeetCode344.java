package gorgeous.algorithm.leetcode;

public class LeetCode344 {

    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
