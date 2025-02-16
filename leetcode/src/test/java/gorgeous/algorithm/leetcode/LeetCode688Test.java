package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode688Test {

    @Test
    public void knightProbability_validInput_returnProbability() {
        // given

        // when
        LeetCode688 leetCode688 = new LeetCode688();
        double answer11 = leetCode688.knightProbability1(3, 2, 0, 0);
        double answer12 = leetCode688.knightProbability1(1, 0, 0, 0);
        double answer21 = leetCode688.knightProbability2(3, 2, 0, 0);
        double answer22 = leetCode688.knightProbability2(1, 0, 0, 0);
        double answer31 = leetCode688.knightProbability3(3, 2, 0, 0);
        double answer32 = leetCode688.knightProbability3(1, 0, 0, 0);

        // then
        Assertions.assertEquals(0.0625, answer11);
        Assertions.assertEquals(1, answer12);
        Assertions.assertEquals(0.0625, answer21);
        Assertions.assertEquals(1, answer22);
        Assertions.assertEquals(0.0625, answer31);
        Assertions.assertEquals(1, answer32);
    }
}
