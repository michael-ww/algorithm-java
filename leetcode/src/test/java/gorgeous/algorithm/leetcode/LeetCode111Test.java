package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode111Test {

    @Test
    public void minDepth_validInput_returnMinDepth() {
        // given
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> three = new TreeNode<>(3);
        four.setLeft(six);
        four.setRight(seven);
        TreeNode<Integer> two = new TreeNode<>(2);
        two.setLeft(four);
        two.setRight(five);
        TreeNode<Integer> one = new TreeNode<>(1);
        one.setLeft(two);
        one.setRight(three);

        // when
        LeetCode111 leetCode111 = new LeetCode111();
        int answer = leetCode111.minDepth(one);

        // then
        Assertions.assertEquals(2, answer);
    }
}
