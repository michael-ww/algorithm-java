package gorgeous.algorithm.leetcode;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode47Test {

    @Test
    public void permuteUnique_ValidInput_returnPermute() {
        // given

        // when
        LeetCode47 leetCode47 = new LeetCode47();
        List<List<Integer>> answer = leetCode47.permuteUnique(new int[]{1, 2, 1});

        // then
        Assertions.assertEquals(3, answer.size());
    }
}
