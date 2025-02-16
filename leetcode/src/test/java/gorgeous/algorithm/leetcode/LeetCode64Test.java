package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode64Test {

    @Test
    public void minPathSum_validInput_returnMinPathSum() {
        // given

        // when
        LeetCode64 leetCode64 = new LeetCode64();
        int answer11 = leetCode64.minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        int answer12 = leetCode64.minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 6}});
        int answer21 = leetCode64.minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        int answer22 = leetCode64.minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 6}});
        int answer31 = leetCode64.minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        int answer32 = leetCode64.minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 6}});
        int answer41 = leetCode64.minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        int answer42 = leetCode64.minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 6}});

        // then
        Assertions.assertEquals(7, answer11);
        Assertions.assertEquals(12, answer12);
        Assertions.assertEquals(7, answer21);
        Assertions.assertEquals(12, answer22);
        Assertions.assertEquals(7, answer31);
        Assertions.assertEquals(12, answer32);
        Assertions.assertEquals(7, answer41);
        Assertions.assertEquals(12, answer42);
    }
}
