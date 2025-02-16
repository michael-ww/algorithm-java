package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode137Test {

    @Test
    public void singleNumber_validInput_returnNumber() {
        // given
        int[] nums1 = {2, 2, 3, 2};
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};

        // when
        LeetCode137 leetCode137 = new LeetCode137();
        int answer1 = leetCode137.singleNumber(nums1);
        int answer2 = leetCode137.singleNumber(nums2);

        // then
        Assertions.assertEquals(3, answer1);
        Assertions.assertEquals(99, answer2);
    }
}
