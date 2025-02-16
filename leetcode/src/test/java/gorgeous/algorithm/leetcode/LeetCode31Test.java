package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode31Test {

    @Test
    public void nextPermutation_validInput_returnNextPermutation() {
        // given
        int[] nums1 = {1, 2, 3}, nums2 = {3, 2, 1}, nums3 = {1, 2, 3, 5, 6, 4}, nums4 = {1, 2, 4, 2};

        // when
        LeetCode31 leetCode31 = new LeetCode31();
        leetCode31.nextPermutation(nums1);
        leetCode31.nextPermutation(nums2);
        leetCode31.nextPermutation(nums3);
        leetCode31.nextPermutation(nums4);

        // then
        Assertions.assertArrayEquals(new int[]{1, 3, 2}, nums1);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, nums2);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 6, 4, 5}, nums3);
        Assertions.assertArrayEquals(new int[]{1, 4, 2, 2}, nums4);
    }
}
