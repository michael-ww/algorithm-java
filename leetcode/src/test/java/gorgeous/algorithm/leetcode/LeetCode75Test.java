package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode75Test {

    @Test
    public void sortColors_validInput_succeed() {
        // given
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};

        // when
        LeetCode75 leetCode75 = new LeetCode75();
        leetCode75.sortColors(nums1);
        leetCode75.sortColors(nums2);

        // then
        Assertions.assertEquals(0, nums1[0]);
        Assertions.assertEquals(0, nums1[1]);
        Assertions.assertEquals(1, nums1[2]);
        Assertions.assertEquals(1, nums1[3]);
        Assertions.assertEquals(2, nums1[4]);
        Assertions.assertEquals(2, nums1[5]);
        Assertions.assertEquals(0, nums2[0]);
        Assertions.assertEquals(1, nums2[1]);
        Assertions.assertEquals(2, nums2[2]);
    }
}
