package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode342Test {

    @Test
    public void isPowerOfFour_validInput_returnBoolean() {
        // given

        // when
        LeetCode342 leetCode342 = new LeetCode342();
        boolean answer1 = leetCode342.isPowerOfFour1(16);
        boolean answer2 = leetCode342.isPowerOfFour1(5);
        boolean answer3 = leetCode342.isPowerOfFour1(1);
        boolean answer4 = leetCode342.isPowerOfFour2(16);
        boolean answer5 = leetCode342.isPowerOfFour2(5);
        boolean answer6 = leetCode342.isPowerOfFour2(1);

        // then
        Assertions.assertTrue(answer1);
        Assertions.assertFalse(answer2);
        Assertions.assertTrue(answer3);
        Assertions.assertTrue(answer4);
        Assertions.assertFalse(answer5);
        Assertions.assertTrue(answer6);

    }
}
