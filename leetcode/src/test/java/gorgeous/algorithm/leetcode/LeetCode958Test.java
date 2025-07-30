package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode958Test {

    @Test
    public void isCompleteTree_validInput_returnTrue() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().setRight(new TreeNode<>(5));
        root.getRight().setLeft(new TreeNode<>(6));

        LeetCode958 solution = new LeetCode958();
        Assertions.assertTrue(solution.isCompleteTree(root));
    }

    @Test
    public void isCompleteTree_validInput_returnFalse() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().setRight(new TreeNode<>(5));
        root.getRight().setRight(new TreeNode<>(7));

        LeetCode958 solution = new LeetCode958();
        Assertions.assertFalse(solution.isCompleteTree(root));
    }

}
