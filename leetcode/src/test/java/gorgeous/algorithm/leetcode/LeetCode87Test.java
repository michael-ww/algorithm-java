package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode87Test {

    @Test
    public void isScramble_validInput_returnBoolean() {
        // given

        // when
        LeetCode87 leetCode87 = new LeetCode87();
        boolean answer11 = leetCode87.isScramble1("great", "rgeat");
        boolean answer12 = leetCode87.isScramble1("abcde", "caebd");
        boolean answer13 = leetCode87.isScramble1("a", "a");
        boolean answer21 = leetCode87.isScramble2("great", "rgeat");
        boolean answer22 = leetCode87.isScramble2("abcde", "caebd");
        boolean answer23 = leetCode87.isScramble2("a", "a");
        boolean answer31 = leetCode87.isScramble3("great", "rgeat");
        boolean answer32 = leetCode87.isScramble3("abcde", "caebd");
        boolean answer33 = leetCode87.isScramble3("a", "a");

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
    }
}
