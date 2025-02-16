package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode516Test {

    @Test
    public void longestPalindromeSubseq_validInput_returnlpCount() {
        // given

        // when
        LeetCode516 leetCode516 = new LeetCode516();
        int answer11 = leetCode516.longestPalindromeSubseq1("bbbab");
        int answer12 = leetCode516.longestPalindromeSubseq1("cbbd");
        int answer21 = leetCode516.longestPalindromeSubseq2("bbbab");
        int answer22 = leetCode516.longestPalindromeSubseq2("cbbd");
        int answer31 = leetCode516.longestPalindromeSubseq3("bbbab");
        int answer32 = leetCode516.longestPalindromeSubseq3("cbbd");
        int answer41 = leetCode516.longestPalindromeSubseq4("bbbab");
        int answer42 = leetCode516.longestPalindromeSubseq4("cbbd");

        // then
        Assertions.assertEquals(4, answer11);
        Assertions.assertEquals(2, answer12);
        Assertions.assertEquals(4, answer21);
        Assertions.assertEquals(2, answer22);
        Assertions.assertEquals(4, answer31);
        Assertions.assertEquals(2, answer32);
        Assertions.assertEquals(4, answer41);
        Assertions.assertEquals(2, answer42);
    }
}
