package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode110Test {

    @Test
    public void isBalanced_validInput_returnBoolean() {
        // Arrange
        LeetCode110 leetCode110 = new LeetCode110();

        TreeNode<Integer> balancedTree = new TreeNode<>(1);
        balancedTree.setLeft(new TreeNode<>(2));
        balancedTree.setRight(new TreeNode<>(3));
        balancedTree.getLeft().setLeft(new TreeNode<>(4));
        balancedTree.getLeft().setRight(new TreeNode<>(5));
        balancedTree.getRight().setRight(new TreeNode<>(6));

        TreeNode<Integer> unbalancedTree = new TreeNode<>(1);
        unbalancedTree.setLeft(new TreeNode<>(2));
        unbalancedTree.getLeft().setLeft(new TreeNode<>(3));
        unbalancedTree.getLeft().getLeft().setLeft(new TreeNode<>(4));

        // Act
        boolean balanced = leetCode110.isBalanced(balancedTree);
        boolean unbalanced = leetCode110.isBalanced(unbalancedTree);

        // Assert
        Assertions.assertTrue(balanced);
        Assertions.assertFalse(unbalanced);
    }
}
