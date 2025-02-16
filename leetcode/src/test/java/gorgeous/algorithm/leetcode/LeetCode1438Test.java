package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode1438Test {

    @Test
    public void longestSubarray_validInput_returnLength() {
        // given

        // when
        LeetCode1438 leetCode1438 = new LeetCode1438();
        int result1 = leetCode1438.longestSubarray(new int[]{8, 2, 4, 7}, 4);
        int result2 = leetCode1438.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);
        int result3 = leetCode1438.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0);
        int result4 = leetCode1438.longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4);
        int result5 = leetCode1438.longestSubarray(new int[]{1, 2, 3, 4, 5}, 4);

        // then
        Assertions.assertEquals(2, result1);
        Assertions.assertEquals(3, result2);
        Assertions.assertEquals(3, result3);
        Assertions.assertEquals(5, result4);
        Assertions.assertEquals(5, result5);

    }
}
