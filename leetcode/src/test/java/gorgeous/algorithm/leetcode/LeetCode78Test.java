package gorgeous.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode78Test {

    @Test
    public void subsets_validInput_returnSubsets() {
        // Arrange
        LeetCode78 leetCode78 = new LeetCode78();

        int[] nums1 = {1, 2, 3};
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        );

        int[] nums2 = {0};
        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)
        );

        // Act
        List<List<Integer>> answer1 = leetCode78.subsets(nums1);
        List<List<Integer>> answer2 = leetCode78.subsets(nums2);

        // Assert
        Assertions.assertEquals(expected1.size(), answer1.size());
        for (List<Integer> elem : answer1) {
            Assertions.assertTrue(expected1.contains(elem));
        }

        Assertions.assertEquals(expected2.size(), answer2.size());
        for (List<Integer> elem : answer2) {
            Assertions.assertTrue(expected2.contains(elem));
        }
    }
}
