package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode3Test {

    @Test
    public void longestDistinctSubstring_validInput_returnSubstring() {
        // given
        String s1 = "abcabcbb", s2 = "bbbbb", s3 = "pwwkew";

        // when
        LeetCode3 leetCode3 = new LeetCode3();
        String answer1 = leetCode3.longestDistinctSubstring1(s1);
        String answer2 = leetCode3.longestDistinctSubstring1(s2);
        String answer3 = leetCode3.longestDistinctSubstring1(s3);

        String answer4 = leetCode3.longestDistinctSubstring2(s1);
        String answer5 = leetCode3.longestDistinctSubstring2(s2);
        String answer6 = leetCode3.longestDistinctSubstring2(s3);

        // then
        Assertions.assertEquals("abc", answer1);
        Assertions.assertEquals("b", answer2);
        Assertions.assertEquals("wke", answer3);

        Assertions.assertEquals("abc", answer4);
        Assertions.assertEquals("b", answer5);
        Assertions.assertEquals("wke", answer6);

    }
}
