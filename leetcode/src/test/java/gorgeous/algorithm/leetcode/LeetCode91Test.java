package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode91Test {

    @Test
    public void numDecodings_validInput_returnNumber() {
        // given

        // when
        LeetCode91 leetCode91 = new LeetCode91();
        int answer11 = leetCode91.numDecodings1("12");
        int answer12 = leetCode91.numDecodings1("226");
        int answer13 = leetCode91.numDecodings1("06");

        int answer21 = leetCode91.numDecodings2("12");
        int answer22 = leetCode91.numDecodings2("226");
        int answer23 = leetCode91.numDecodings2("06");

        int answer31 = leetCode91.numDecodings3("12");
        int answer32 = leetCode91.numDecodings3("226");
        int answer33 = leetCode91.numDecodings3("06");

        int answer41 = leetCode91.numDecodings4("12");
        int answer42 = leetCode91.numDecodings4("226");
        int answer43 = leetCode91.numDecodings4("06");

        // then
        Assertions.assertEquals(2, answer11);
        Assertions.assertEquals(3, answer12);
        Assertions.assertEquals(0, answer13);

        Assertions.assertEquals(2, answer21);
        Assertions.assertEquals(3, answer22);
        Assertions.assertEquals(0, answer23);

        Assertions.assertEquals(2, answer31);
        Assertions.assertEquals(3, answer32);
        Assertions.assertEquals(0, answer33);

        Assertions.assertEquals(2, answer41);
        Assertions.assertEquals(3, answer42);
        Assertions.assertEquals(0, answer43);
    }
}
