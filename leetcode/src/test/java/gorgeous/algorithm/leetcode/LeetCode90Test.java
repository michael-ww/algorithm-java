package gorgeous.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode90Test {

    @Test
    public void subsetsWithDup_validInput_returnSubsets() {
        // Arrange
        LeetCode90 leetCode90 = new LeetCode90();

        int[] nums1 = {1, 2, 2};
        int[] nums2 = {0};
        int[] nums3 = {1, 1, 2, 2};

        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2),
                Arrays.asList(2, 2)
        );
        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(0)
        );
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1, 2),
                Arrays.asList(1, 1, 2, 2),
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2),
                Arrays.asList(2, 2)
        );

        // Act
        List<List<Integer>> answer1 = leetCode90.subsetsWithDup(nums1);
        List<List<Integer>> answer2 = leetCode90.subsetsWithDup(nums2);
        List<List<Integer>> answer3 = leetCode90.subsetsWithDup(nums3);

        // Assert
        Assertions.assertEquals(expected1.size(), answer1.size());
        for (List<Integer> elem : answer1) {
            Assertions.assertTrue(expected1.contains(elem));
        }

        Assertions.assertEquals(expected2.size(), answer2.size());
        for (List<Integer> elem : answer2) {
            Assertions.assertTrue(expected2.contains(elem));
        }

        Assertions.assertEquals(expected3.size(), answer3.size());
        for (List<Integer> elem : answer3) {
            Assertions.assertTrue(expected3.contains(elem));
        }
    }
}
