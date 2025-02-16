package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode97Test {

    @Test
    public void isInterleave_validInput_returnBoolean() {
        // given

        // when
        LeetCode97 leetCode97 = new LeetCode97();
        boolean answer11 = leetCode97.isInterleave1("aabcc", "dbbca", "aadbbcbcac");
        boolean answer12 = leetCode97.isInterleave1("aabcc", "dbbca", "aadbbbaccc");
        boolean answer13 = leetCode97.isInterleave1("", "", "");
        boolean answer21 = leetCode97.isInterleave2("aabcc", "dbbca", "aadbbcbcac");
        boolean answer22 = leetCode97.isInterleave2("aabcc", "dbbca", "aadbbbaccc");
        boolean answer23 = leetCode97.isInterleave2("", "", "");
        boolean answer31 = leetCode97.isInterleave3("aabcc", "dbbca", "aadbbcbcac");
        boolean answer32 = leetCode97.isInterleave3("aabcc", "dbbca", "aadbbbaccc");
        boolean answer33 = leetCode97.isInterleave3("", "", "");
        boolean answer41 = leetCode97.isInterleave4("aabcc", "dbbca", "aadbbcbcac");
        boolean answer42 = leetCode97.isInterleave4("aabcc", "dbbca", "aadbbbaccc");
        boolean answer43 = leetCode97.isInterleave4("", "", "");

        // then
        Assertions.assertTrue(answer11);
        Assertions.assertFalse(answer12);
        Assertions.assertTrue(answer13);
        Assertions.assertTrue(answer21);
        Assertions.assertFalse(answer22);
        Assertions.assertTrue(answer23);
        Assertions.assertTrue(answer31);
        Assertions.assertFalse(answer32);
        Assertions.assertTrue(answer33);
        Assertions.assertTrue(answer41);
        Assertions.assertFalse(answer42);
        Assertions.assertTrue(answer43);
    }
}
