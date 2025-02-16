package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode940Test {

    @Test
    public void distinctSubseqII_validInput_returnCount() {
        // Arrange
        LeetCode940 leetCode940 = new LeetCode940();

        // Act
        int answer1 = leetCode940.distinctSubseqII("abc");
        int answer2 = leetCode940.distinctSubseqII("aba");
        int answer3 = leetCode940.distinctSubseqII("aaa");
        int answer4 = leetCode940.distinctSubseqII("abcd");
        int answer5 = leetCode940.distinctSubseqII("");

        // Assert
        Assertions.assertEquals(7, answer1);
        Assertions.assertEquals(6, answer2);
        Assertions.assertEquals(3, answer3);
        Assertions.assertEquals(15, answer4);
        Assertions.assertEquals(0, answer5);
    }
}
