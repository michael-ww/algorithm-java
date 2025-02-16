package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode639Test {

    @Test
    public void numDecodings_validInput_returnNumber() {
        // given

        // when
        LeetCode639 leetCode639 = new LeetCode639();
        int answer11 = leetCode639.numDecodings1("*");
        int answer12 = leetCode639.numDecodings1("1*");
        int answer13 = leetCode639.numDecodings1("2*");
        int answer21 = leetCode639.numDecodings2("*");
        int answer22 = leetCode639.numDecodings2("1*");
        int answer23 = leetCode639.numDecodings2("2*");
        int answer31 = leetCode639.numDecodings3("*");
        int answer32 = leetCode639.numDecodings3("1*");
        int answer33 = leetCode639.numDecodings3("2*");
        int answer41 = leetCode639.numDecodings4("*");
        int answer42 = leetCode639.numDecodings4("1*");
        int answer43 = leetCode639.numDecodings4("2*");

        // then
        Assertions.assertEquals(9, answer11);
        Assertions.assertEquals(18, answer12);
        Assertions.assertEquals(15, answer13);
        Assertions.assertEquals(9, answer21);
        Assertions.assertEquals(18, answer22);
        Assertions.assertEquals(15, answer23);
        Assertions.assertEquals(9, answer31);
        Assertions.assertEquals(18, answer32);
        Assertions.assertEquals(15, answer33);
        Assertions.assertEquals(9, answer41);
        Assertions.assertEquals(18, answer42);
        Assertions.assertEquals(15, answer43);
    }
}
