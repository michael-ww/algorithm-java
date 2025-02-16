package gorgeous.algorithm.leetcode;

import java.util.Stack;

public class LeetCode20 {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (s.charAt(i) == ')' && stack.pop() != '(') {
                    return false;
                } else if (s.charAt(i) == ']' && stack.pop() != '[') {
                    return false;
                } else if (s.charAt(i) == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return true;
    }
}
