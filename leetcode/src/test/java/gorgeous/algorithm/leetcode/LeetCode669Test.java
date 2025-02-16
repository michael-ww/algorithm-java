package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode669Test {

    @Test
    public void trimBST_validInput_returnRoot() {
        // Arrange
        LeetCode669 solution = new LeetCode669();

        TreeNode<Integer> root = new TreeNode<>(3);
        root.setLeft(new TreeNode<>(0));
        root.setRight(new TreeNode<>(4));
        root.getLeft().setRight(new TreeNode<>(2));
        root.getLeft().getRight().setLeft(new TreeNode<>(1));

        // Act
        TreeNode<Integer> trimmed = solution.trimBST(root, 1, 3);

        // Assert
        Assertions.assertNotNull(trimmed);
        Assertions.assertEquals(3, trimmed.getValue().intValue());
        Assertions.assertEquals(2, trimmed.getLeft().getValue().intValue());
        Assertions.assertEquals(1, trimmed.getLeft().getLeft().getValue().intValue());
        Assertions.assertNull(trimmed.getRight());
    }

}
