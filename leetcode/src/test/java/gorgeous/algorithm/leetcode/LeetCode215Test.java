package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode215Test {

    @Test
    public void findKthLargest_validInput_returnKthNumber() {
        // given

        // when
        LeetCode215 leetCode215 = new LeetCode215();
        int answer11 = leetCode215.findKthLargest1(new int[]{3, 2, 1, 5, 6, 4}, 2);
        int answer12 = leetCode215.findKthLargest1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        int answer21 = leetCode215.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2);
        int answer22 = leetCode215.findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);

        // then
        Assertions.assertEquals(5, answer11);
        Assertions.assertEquals(4, answer12);
        Assertions.assertEquals(5, answer21);
        Assertions.assertEquals(4, answer22);

    }
}
