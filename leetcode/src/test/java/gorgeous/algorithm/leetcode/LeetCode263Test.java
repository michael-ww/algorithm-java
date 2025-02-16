package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode263Test {

    @Test
    public void isUgly_validInput_returnBoolean() {
        // given

        // when
        LeetCode263 leetCode263 = new LeetCode263();
        boolean answer1 = leetCode263.isUgly(2);
        boolean answer2 = leetCode263.isUgly(6);
        boolean answer3 = leetCode263.isUgly(14);
        boolean answer4 = leetCode263.isUgly(149870);

        //then
        Assertions.assertTrue(answer1);
        Assertions.assertTrue(answer2);
        Assertions.assertFalse(answer3);
        Assertions.assertFalse(answer4);

    }
}
