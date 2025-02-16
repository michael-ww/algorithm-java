package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode60Test {

    @Test
    public void getPermutation_validInput_returnKthPermutation() {
        // given

        // when
        LeetCode60 leetCode60 = new LeetCode60();
        String answer1 = leetCode60.getPermutation1(3, 3);
        String answer2 = leetCode60.getPermutation1(4, 9);
        String answer3 = leetCode60.getPermutation1(6, 9);

        // then
        Assertions.assertEquals("213", answer1);
        Assertions.assertEquals("2314", answer2);
        Assertions.assertEquals("124536", answer3);
    }
}
