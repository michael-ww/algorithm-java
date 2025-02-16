package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode198Test {

    @Test
    public void rob_validInput_returnMax() {
        // given

        // when
        LeetCode198 leetCode198 = new LeetCode198();
        int answer11 = leetCode198.rob1(new int[]{1, 2, 3, 1});
        int answer12 = leetCode198.rob1(new int[]{2, 7, 9, 3, 1});
        int answer21 = leetCode198.rob2(new int[]{1, 2, 3, 1});
        int answer22 = leetCode198.rob2(new int[]{2, 7, 9, 3, 1});
        int answer31 = leetCode198.rob3(new int[]{1, 2, 3, 1});
        int answer32 = leetCode198.rob3(new int[]{2, 7, 9, 3, 1});

        // then
        Assertions.assertEquals(4, answer11);
        Assertions.assertEquals(12, answer12);
        Assertions.assertEquals(4, answer21);
        Assertions.assertEquals(12, answer22);
        Assertions.assertEquals(4, answer31);
        Assertions.assertEquals(12, answer32);
    }
}
