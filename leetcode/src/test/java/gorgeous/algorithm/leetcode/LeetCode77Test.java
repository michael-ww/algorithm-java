package gorgeous.algorithm.leetcode;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode77Test {

    @Test
    public void combine_validInput_returnCombinations() {
        LeetCode77 leetCode77 = new LeetCode77();

        var result1 = leetCode77.combine(4, 2);
        Assertions.assertEquals(6, result1.size());
        Assertions.assertTrue(result1.contains(List.of(1, 2)));
        Assertions.assertTrue(result1.contains(List.of(1, 3)));
        Assertions.assertTrue(result1.contains(List.of(1, 4)));
        Assertions.assertTrue(result1.contains(List.of(2, 3)));
        Assertions.assertTrue(result1.contains(List.of(2, 4)));
        Assertions.assertTrue(result1.contains(List.of(3, 4)));

        List<List<Integer>> result2 = leetCode77.combine(1, 1);
        Assertions.assertEquals(1, result2.size());
        Assertions.assertTrue(result2.contains(List.of(1)));

        List<List<Integer>> result3 = leetCode77.combine(5, 3);
        Assertions.assertEquals(10, result3.size());
        Assertions.assertTrue(result3.contains(List.of(1, 2, 3)));
        Assertions.assertTrue(result3.contains(List.of(1, 2, 4)));
        Assertions.assertTrue(result3.contains(List.of(1, 2, 5)));
        Assertions.assertTrue(result3.contains(List.of(1, 3, 4)));
        Assertions.assertTrue(result3.contains(List.of(1, 3, 5)));
        Assertions.assertTrue(result3.contains(List.of(1, 4, 5)));
        Assertions.assertTrue(result3.contains(List.of(2, 3, 4)));
        Assertions.assertTrue(result3.contains(List.of(2, 3, 5)));
        Assertions.assertTrue(result3.contains(List.of(2, 4, 5)));
        Assertions.assertTrue(result3.contains(List.of(3, 4, 5)));
    }
}
