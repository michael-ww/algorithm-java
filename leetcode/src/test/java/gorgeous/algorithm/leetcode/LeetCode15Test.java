package gorgeous.algorithm.leetcode;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode15Test {

    @Test
    public void threeSum_validInput_returnArrayList() {
        // given

        // when
        LeetCode15 leetCode15 = new LeetCode15();
        List<List<Integer>> answer1 = leetCode15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> answer2 = leetCode15.threeSum(new int[]{0, 1, 1});
        List<List<Integer>> answer3 = leetCode15.threeSum(new int[]{0, 0, 0});

        // then
        Assertions.assertEquals(2, answer1.size());
        Assertions.assertEquals(0, answer2.size());
        Assertions.assertEquals(1, answer3.size());
    }
}
