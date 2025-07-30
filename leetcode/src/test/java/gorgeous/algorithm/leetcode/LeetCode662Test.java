package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode662Test {

    @Test
    public void widthOfBinaryTree_validInput_returnWidth() {
        // given
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(3));
        root.setRight(new TreeNode<>(2));
        root.getLeft().setLeft(new TreeNode<>(5));
        root.getRight().setRight(new TreeNode<>(9));
        root.getLeft().getLeft().setLeft(new TreeNode<>(6));
        root.getRight().getRight().setLeft(new TreeNode<>(7));

        LeetCode662 solution = new LeetCode662();

        // when
        int result = solution.widthOfBinaryTree(root);

        // then
        Assertions.assertEquals(7, result);
    }
}
