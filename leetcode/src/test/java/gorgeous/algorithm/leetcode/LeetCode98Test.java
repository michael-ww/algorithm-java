package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;

public class LeetCode98Test {

    //@Test
    public void isValidBST1_validInput_returnBoolean() {
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
        boolean answer1 = new LeetCode98().isValidBST1(one);
        boolean answer2 = new LeetCode98().isValidBST2(one);
        boolean answer3 = new LeetCode98().isValidBST3(one);

        // Than
        Assertions.assertFalse(answer1);
        Assertions.assertFalse(answer2);
        Assertions.assertFalse(answer3);
    }

    //@Test
    public void isValidBST2_validInput_returnBoolean() {
        // Given
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> six = new TreeNode<>(5);
        TreeNode<Integer> five = new TreeNode<>(3);
        TreeNode<Integer> four = new TreeNode<>(1);
        TreeNode<Integer> three = new TreeNode<>(6);
        three.setLeft(six);
        three.setRight(seven);
        TreeNode<Integer> two = new TreeNode<>(2);
        two.setLeft(four);
        two.setRight(five);
        TreeNode<Integer> one = new TreeNode<>(4);
        one.setLeft(two);
        one.setRight(three);

        // When
        boolean answer = new LeetCode98().isValidBST1(one);

        // Than
        Assertions.assertTrue(answer);

    }

}
