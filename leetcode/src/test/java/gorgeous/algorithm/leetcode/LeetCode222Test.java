package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode222Test {

    @Test
    public void countNodes_validInput_returnCount() {
        // Arrange
        LeetCode222 leetCode222 = new LeetCode222();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().setRight(new TreeNode<>(5));
        root.getRight().setLeft(new TreeNode<>(6));

        // Act
        int answer = leetCode222.countNodes(root);

        // Assert
        Assertions.assertEquals(6, answer);
    }
}
