package gorgeous.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode102Test {

    @Test
    public void levelOrder_validInput_returnList() {
        // given
        TreeNode<Integer> root = new TreeNode<>(3);
        root.setLeft(new TreeNode<>(9));
        root.setRight(new TreeNode<>(20));
        root.getRight().setLeft(new TreeNode<>(15));
        root.getRight().setRight(new TreeNode<>(7));

        LeetCode102 leetCode102 = new LeetCode102();

        // when
        List<List<Integer>> result1 = leetCode102.levelOrder1(root);
        List<List<Integer>> result2 = leetCode102.levelOrder2(root);

        // then
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );
        Assertions.assertEquals(expected, result1);
        Assertions.assertEquals(expected, result2);

    }
}
