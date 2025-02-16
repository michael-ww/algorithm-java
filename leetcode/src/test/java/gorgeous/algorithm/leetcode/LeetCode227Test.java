package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode227Test {

    @Test
    public void calculate_validInput_returnResult() {
        LeetCode227 calculator = new LeetCode227();

        Assertions.assertEquals(7, calculator.calculate("3+2*2"));
        Assertions.assertEquals(1, calculator.calculate(" 3/2 "));
        Assertions.assertEquals(5, calculator.calculate(" 3+5 / 2 "));
        Assertions.assertEquals(0, calculator.calculate("0"));
        Assertions.assertEquals(42, calculator.calculate("42"));
        Assertions.assertEquals(9, calculator.calculate("10-1"));
        Assertions.assertEquals(6, calculator.calculate("2*3"));
        Assertions.assertEquals(2, calculator.calculate("8/4"));
        Assertions.assertEquals(8, calculator.calculate("2+2*2+2"));
        Assertions.assertEquals(1, calculator.calculate("1-1+1"));
    }
}
