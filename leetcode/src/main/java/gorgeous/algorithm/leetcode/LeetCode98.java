package gorgeous.algorithm.leetcode;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode98 {

    public boolean isValidBST1(TreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        return this.inorderTraversal(root, new AtomicInteger(Integer.MIN_VALUE));
    }

    private boolean inorderTraversal(TreeNode<Integer> root, AtomicInteger previous) {
        if (root == null) {
            return true;
        }
        boolean left = this.inorderTraversal(root.getLeft(), previous);
        if (!left) {
            return false;
        }
        if (root.getValue() <= previous.get()) {
            return false;
        } else {
            previous.set(root.getValue());
        }
        return this.inorderTraversal(root.getRight(), previous);
    }

    public boolean isValidBST2(TreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        Integer previous = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                if (root.getValue() <= previous) {
                    return false;
                } else {
                    previous = root.getValue();
                }
                root = root.getRight();
            } else {
                stack.push(root);
                root = root.getLeft();
            }
        }

        return true;
    }

    public boolean isValidBST3(TreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        int previous = Integer.MIN_VALUE;
        TreeNode<Integer> current = root;
        while (current != null) {
            TreeNode<Integer> mostRight = current.getLeft();
            if (mostRight == null) {

            } else {
                while (mostRight.getLeft() != null && mostRight.getLeft() != current) {

                }
            }
        }
        return true;
    }
}
