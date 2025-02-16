package gorgeous.algorithm.leetcode;

import java.util.Stack;

public class LeetCode227 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char previousSymbol = '+';
        for (int index = 0, current = 0; index < s.length(); index++) {
            if (Character.isDigit(s.charAt(index))) {
                current = current * 10 + (s.charAt(index) - '0');
            }
            if ((!Character.isDigit(s.charAt(index)) && !Character.isWhitespace(s.charAt(index))) || index == s.length() - 1) {
                switch (previousSymbol) {
                    case '+' ->
                        stack.add(current);
                    case '-' ->
                        stack.add(-current);
                    case '*' ->
                        stack.add(stack.pop() * current);
                    case '/' ->
                        stack.add(stack.pop() / current);
                    default ->
                        throw new AssertionError();
                }
                previousSymbol = s.charAt(index);
                current = 0;
            }

        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
