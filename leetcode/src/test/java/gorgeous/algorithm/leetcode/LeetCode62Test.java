package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode62Test {

    @Test
    public void uniquePaths_validInput_returnPathCount() {
        // given

        // when
        LeetCode62 leetCode62 = new LeetCode62();
        int answer1 = leetCode62.uniquePaths(3, 7);
        int answer2 = leetCode62.uniquePaths(3, 2);
        int answer3 = leetCode62.uniquePaths(7, 3);
        int answer4 = leetCode62.uniquePaths(3, 3);

        // then
        Assertions.assertEquals(28, answer1);
        Assertions.assertEquals(3, answer2);
        Assertions.assertEquals(28, answer3);
        Assertions.assertEquals(6, answer4);
    }
}
