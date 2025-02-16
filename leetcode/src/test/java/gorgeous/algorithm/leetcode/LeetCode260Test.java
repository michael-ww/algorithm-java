package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode260Test {

    @Test
    public void singleNumber_validInput_returnNumbers() {
        // given
        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] nums2 = {-1, 0};

        // when
        LeetCode260 leetCode260 = new LeetCode260();
        int[] answer1 = leetCode260.singleNumber(nums1);
        int[] answer2 = leetCode260.singleNumber(nums2);

        // then
        Assertions.assertEquals(3, answer1[0]);
        Assertions.assertEquals(5, answer1[1]);
        Assertions.assertEquals(-1, answer2[0]);
        Assertions.assertEquals(0, answer2[1]);
    }
}
