package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode106Test {

    @Test
    public void testBuildTree() {
        // Arrange
        LeetCode106 leetCode106 = new LeetCode106();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // Act
        TreeNode<Integer> root = leetCode106.buildTree(inorder, postorder);

        // Assert
        Assertions.assertNotNull(root);
        Assertions.assertEquals(3, root.getValue());
        Assertions.assertEquals(9, root.getLeft().getValue());
        Assertions.assertEquals(20, root.getRight().getValue());
        Assertions.assertEquals(15, root.getRight().getLeft().getValue());
        Assertions.assertEquals(7, root.getRight().getRight().getValue());
    }
}
