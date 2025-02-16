package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode28Test {

    @Test
    public void strStr_validInput_returnStartIndex() {
        // given

        // when
        LeetCode28 leetCode28 = new LeetCode28();
        int answer1 = leetCode28.strStr("sadbutsad", "sad");
        int answer2 = leetCode28.strStr("leetcode", "leeto");

        // then
        Assertions.assertEquals(0, answer1);
        Assertions.assertEquals(-1, answer2);

    }
}
