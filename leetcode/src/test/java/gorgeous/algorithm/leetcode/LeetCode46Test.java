package gorgeous.algorithm.leetcode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode46Test {

    @Test
    public void permute_validInput_returnPermute() {
        // given

        // when
        LeetCode46 leetCode46 = new LeetCode46();
        List<List<Integer>> answer = leetCode46.permute(new int[]{1, 2, 3});

        // then
        Assertions.assertEquals(6, answer.size());
    }
}
