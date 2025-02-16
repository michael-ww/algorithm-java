package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode1Test {

    @Test
    public void twoSum_validInput_returnSum() {
        // given
        int[] nums1 = {2, 7, 11, 15}, nums2 = {3, 2, 4}, nums3 = {3, 3};

        // when
        LeetCode1 leetCode1 = new LeetCode1();
        int[] answer11 = leetCode1.twoSum1(nums1, 9);
        int[] answer12 = leetCode1.twoSum1(nums2, 6);
        int[] answer13 = leetCode1.twoSum1(nums3, 6);

        int[] answer21 = leetCode1.twoSum2(nums1, 9);
        int[] answer22 = leetCode1.twoSum2(nums2, 6);
        int[] answer23 = leetCode1.twoSum2(nums3, 6);

        // then
        Assertions.assertArrayEquals(new int[]{0, 1}, answer11);
        Assertions.assertArrayEquals(new int[]{1, 2}, answer12);
        Assertions.assertArrayEquals(new int[]{0, 1}, answer13);

        Assertions.assertArrayEquals(new int[]{0, 1}, answer21);
        Assertions.assertArrayEquals(new int[]{1, 2}, answer22);
        Assertions.assertArrayEquals(new int[]{0, 1}, answer23);
    }
}
