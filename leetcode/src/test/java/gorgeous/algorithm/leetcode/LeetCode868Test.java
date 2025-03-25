package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode868Test {

    @Test
    public void binaryGap_validInput_returnMaxGap() {
        // Arrange
        LeetCode868 leetCode868 = new LeetCode868();

        // Act
        int answer1 = leetCode868.binaryGap(22);
        int answer2 = leetCode868.binaryGap(8);
        int answer3 = leetCode868.binaryGap(5);

        //Assert
        Assertions.assertEquals(2, answer1);
        Assertions.assertEquals(0, answer2);
        Assertions.assertEquals(2, answer3);
    }
}
