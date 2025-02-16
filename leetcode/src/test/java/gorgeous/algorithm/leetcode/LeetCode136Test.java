package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode136Test {

    @Test
    public void singleNumber_validInput_returnNumber() {
        // given
        int[] nums1 = {4, 1, 2, 1, 2};
        int[] nums2 = {2, 2, 1};

        // when
        int answer1 = new LeetCode136().singleNumber(nums1);
        int answer2 = new LeetCode136().singleNumber(nums2);

        // then
        Assertions.assertEquals(4, answer1);
        Assertions.assertEquals(1, answer2);
    }
}
