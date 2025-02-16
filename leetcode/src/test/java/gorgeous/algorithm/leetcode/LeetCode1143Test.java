package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode1143Test {

    @Test
    public void longestCommonSubsequence_validInput_returnLcsCount() {
        // given

        // when
        LeetCode1143 leetCode1143 = new LeetCode1143();
        int answer11 = leetCode1143.longestCommonSubsequence1("abcde", "ace");
        int answer12 = leetCode1143.longestCommonSubsequence1("abc", "abc");
        int answer13 = leetCode1143.longestCommonSubsequence1("abc", "def");
        int answer21 = leetCode1143.longestCommonSubsequence2("abcde", "ace");
        int answer22 = leetCode1143.longestCommonSubsequence2("abc", "abc");
        int answer23 = leetCode1143.longestCommonSubsequence2("abc", "def");
        int answer31 = leetCode1143.longestCommonSubsequence3("abcde", "ace");
        int answer32 = leetCode1143.longestCommonSubsequence3("abc", "abc");
        int answer33 = leetCode1143.longestCommonSubsequence3("abc", "def");
        int answer41 = leetCode1143.longestCommonSubsequence4("abcde", "ace");
        int answer42 = leetCode1143.longestCommonSubsequence4("abc", "abc");
        int answer43 = leetCode1143.longestCommonSubsequence4("abc", "def");

        // then
        Assertions.assertEquals(3, answer11);
        Assertions.assertEquals(3, answer12);
        Assertions.assertEquals(0, answer13);
        Assertions.assertEquals(3, answer21);
        Assertions.assertEquals(3, answer22);
        Assertions.assertEquals(0, answer23);
        Assertions.assertEquals(3, answer31);
        Assertions.assertEquals(3, answer32);
        Assertions.assertEquals(0, answer33);
        Assertions.assertEquals(3, answer41);
        Assertions.assertEquals(3, answer42);
        Assertions.assertEquals(0, answer43);
    }
}
