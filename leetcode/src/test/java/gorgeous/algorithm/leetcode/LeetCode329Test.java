package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode329Test {

    @Test
    public void longestIncreasingPath_validInput_returnLongest() {
        // given

        // when
        LeetCode329 leetCode329 = new LeetCode329();
        int answer11 = leetCode329.longestIncreasingPath1(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
        int answer12 = leetCode329.longestIncreasingPath1(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
        int answer13 = leetCode329.longestIncreasingPath1(new int[][]{{1}});
        int answer21 = leetCode329.longestIncreasingPath2(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
        int answer22 = leetCode329.longestIncreasingPath2(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
        int answer23 = leetCode329.longestIncreasingPath2(new int[][]{{1}});

        // then
        Assertions.assertEquals(4, answer11);
        Assertions.assertEquals(4, answer12);
        Assertions.assertEquals(1, answer13);

        Assertions.assertEquals(4, answer21);
        Assertions.assertEquals(4, answer22);
        Assertions.assertEquals(1, answer23);

    }
}
