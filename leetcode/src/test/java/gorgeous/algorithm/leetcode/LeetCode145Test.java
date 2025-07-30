package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode145Test {

    @Test
    public void postorderTraversal_validInput_ReturnList() {
        // Given
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> three = new TreeNode<>(3);
        three.setLeft(six);
        three.setRight(seven);
        TreeNode<Integer> two = new TreeNode<>(2);
        two.setLeft(four);
        two.setRight(five);
        TreeNode<Integer> one = new TreeNode<>(1);
        one.setLeft(two);
        one.setRight(three);

        // When
        LeetCode145 leetCode145 = new LeetCode145();
        List<Integer> answer1 = leetCode145.postorderTraversal1(one);
        List<Integer> answer2 = leetCode145.postorderTraversal2(one);
        List<Integer> answer3 = leetCode145.postorderTraversal3(one);

        // Then
        List<Integer> expected = new ArrayList<>();
        expected.add(4); // { 4, 5, 2, 6, 7, 3, 1 };
        expected.add(5);
        expected.add(2);
        expected.add(6);
        expected.add(7);
        expected.add(3);
        expected.add(1);
        Assertions.assertEquals(expected, answer1);
        Assertions.assertEquals(expected, answer2);
        Assertions.assertEquals(expected, answer3);
    }
}
