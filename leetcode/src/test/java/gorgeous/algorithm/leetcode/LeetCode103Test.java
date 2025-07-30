package gorgeous.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode103Test {

    @Test
    public void testZigzagLevelOrder() {
        LeetCode103 solution = new LeetCode103();

        TreeNode<Integer> root = new TreeNode<>(3);
        root.setLeft(new TreeNode<>(9));
        root.setRight(new TreeNode<>(20));
        root.getRight().setLeft(new TreeNode<>(15));
        root.getRight().setRight(new TreeNode<>(7));

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(20, 9),
                Arrays.asList(15, 7));

        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        Assertions.assertEquals(expected, result);
    }
}
