package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode63Test {

    @Test
    public void uniquePathsWithObstacles_validInput_returnPathCount() {
        // given

        // when
        LeetCode63 leetCode63 = new LeetCode63();
        int answer1 = leetCode63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        int answer2 = leetCode63.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}});

        // then
        Assertions.assertEquals(2, answer1);
        Assertions.assertEquals(1, answer2);
    }
}
