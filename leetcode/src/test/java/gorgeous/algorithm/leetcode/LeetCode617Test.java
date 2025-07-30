package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode617Test {

    @Test
    public void mergeTrees_validInput_returnTree() {
        // given
        TreeNode<Integer> r15 = new TreeNode<>(5);
        TreeNode<Integer> r13 = new TreeNode<>(3);
        r13.setLeft(r15);
        TreeNode<Integer> r12 = new TreeNode<>(2);
        TreeNode<Integer> r11 = new TreeNode<>(1);
        r11.setLeft(r13);
        r11.setRight(r12);

        TreeNode<Integer> r27 = new TreeNode<>(7);
        TreeNode<Integer> r24 = new TreeNode<>(4);
        TreeNode<Integer> r23 = new TreeNode<>(3);
        r23.setRight(r27);
        TreeNode<Integer> r21 = new TreeNode<>(1);
        r21.setRight(r24);
        TreeNode<Integer> r22 = new TreeNode<>(2);
        r22.setLeft(r21);
        r22.setRight(r23);

        // when
        TreeNode<Integer> answer = new LeetCode617().mergeTrees(r11, r22);

        // then
        Assertions.assertEquals(3, answer.getValue());
        Assertions.assertEquals(4, answer.getLeft().getValue());
        Assertions.assertEquals(5, answer.getRight().getValue());
        Assertions.assertEquals(5, answer.getLeft().getLeft().getValue());
        Assertions.assertEquals(4, answer.getLeft().getRight().getValue());
        Assertions.assertEquals(7, answer.getRight().getRight().getValue());
        Assertions.assertNull(answer.getRight().getLeft());
    }
}
