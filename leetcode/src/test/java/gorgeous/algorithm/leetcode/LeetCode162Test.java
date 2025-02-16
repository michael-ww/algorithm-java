package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode162Test {

    @Test
    public void findPeakElement_validInput_returnIndex() {
        // given
        LeetCode162 solution = new LeetCode162();
        int[] nums1 = {1}, nums2 = {1, 2}, nums3 = {1, 2, 3, 1}, nums4 = {1, 2, 2, 3, 3, 2, 1},
                nums5 = {5, 4, 3, 2, 1}, nums6 = {1, 2, 3, 4, 5};

        // when
        int result1 = solution.findPeakElement(nums1);
        int result2 = solution.findPeakElement(nums2);
        int result3 = solution.findPeakElement(nums3);
        int result4 = solution.findPeakElement(nums4);
        int result5 = solution.findPeakElement(nums5);
        int result6 = solution.findPeakElement(nums6);

        // then
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(1, result2);
        Assertions.assertEquals(2, result3);
        Assertions.assertEquals(3, result4);
        Assertions.assertEquals(0, result5);
        Assertions.assertEquals(4, result6);

    }
}
