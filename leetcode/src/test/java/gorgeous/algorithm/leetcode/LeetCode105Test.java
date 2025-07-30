package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode105Test {

    @Test
    public void buildTree_validInput_returnRoot() {
        // Arrange
        LeetCode105 leetCode105 = new LeetCode105();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Act
        TreeNode<Integer> root = leetCode105.buildTree(preorder, inorder);

        // Assert
        Assertions.assertNotNull(root);
        Assertions.assertEquals(3, root.getValue());
        Assertions.assertEquals(9, root.getLeft().getValue());
        Assertions.assertEquals(20, root.getRight().getValue());
        Assertions.assertEquals(15, root.getRight().getLeft().getValue());
        Assertions.assertEquals(7, root.getRight().getRight().getValue());
    }
}
