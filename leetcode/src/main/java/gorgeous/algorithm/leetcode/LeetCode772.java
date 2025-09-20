package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode772 {

    private int where;

    public int calculate(String s) {
        where = 0;
        return this.calculate(s.toCharArray(), 0);
    }

    private int calculate(char[] chars, int index) {
        int current = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        while (index < chars.length && chars[index] != ')') {
            if (chars[index] >= '0' && chars[index] <= '9') {
                current = current * 10 + (chars[index] - '0');
                index++;
            } else if (chars[index] == '(') {
                current = this.calculate(chars, index + 1);
                index = where + 1;
            } else if (Character.isWhitespace(chars[index])) {
                index++;
            } else {
                this.calculate(numbers, operators, current, chars[index]);
                current = 0;
                index++;
            }
        }
        this.calculate(numbers, operators, current, '+');
        where = index;
        return calculate(numbers, operators);
    }

    private void calculate(List<Integer> numbers, List<Character> operators, int current, char operator) {
        if (numbers.isEmpty() || operators.isEmpty() || operators.getLast() == '+' || operators.getLast() == '-') {
            numbers.add(current);
            operators.add(operator);
        } else {
            char pop = operators.removeLast();
            int number = numbers.removeLast();
            if (pop == '*') {
                numbers.add(number * current);
            } else {
                numbers.add(number / current);
            }
            operators.add(operator);
        }
    }

    private int calculate(List<Integer> numbers, List<Character> operators) {
        int result = numbers.removeFirst();
        while (!numbers.isEmpty()) {
            result += operators.removeFirst() == '+' ? numbers.removeFirst() : -numbers.removeFirst();
        }
        return result;
    }
}
