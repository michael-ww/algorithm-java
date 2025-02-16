package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode2208Test {

    @Test
    public void halveArray_validInput_returnExpected() {
        // given
        int[] nums1 = new int[]{5, 19, 8, 1};
        int[] nums2 = new int[]{3, 8, 20};
        LeetCode2208 leetCode2208 = new LeetCode2208();

        // when
        int answer11 = leetCode2208.halveArray1(nums1);
        int answer12 = leetCode2208.halveArray1(nums2);
        int answer21 = leetCode2208.halveArray2(nums1);
        int answer22 = leetCode2208.halveArray2(nums2);

        // then
        Assertions.assertEquals(3, answer11);
        Assertions.assertEquals(3, answer12);
        Assertions.assertEquals(3, answer21);
        Assertions.assertEquals(3, answer22);
    }
}
