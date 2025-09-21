package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode94 {

    public List<Integer> inorderTraversal1(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        this.inorderTraversal(root, answer);
        return answer;
    }

    private void inorderTraversal(TreeNode<Integer> tn, List<Integer> answer) {
        if (tn == null) {
            return;
        }
        this.inorderTraversal(tn.getLeft(), answer);
        answer.add(tn.getValue());
        this.inorderTraversal(tn.getRight(), answer);
    }

    public List<Integer> inorderTraversal2(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                answer.add(root.getValue());
                root = root.getRight();
            } else {
                stack.push(root);
                root = root.getLeft();
            }
        }

        return answer;
    }

    public List<Integer> inorderTraversal3(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        TreeNode<Integer> current = root;
        while (current != null) {
            TreeNode<Integer> mostRight = current.getLeft();
            if (mostRight != null) {
                while (mostRight.getRight() != null && mostRight.getRight() != current) {
                    mostRight = mostRight.getRight();
                }
                if (mostRight.getRight() == null) {
                    mostRight.setRight(current);
                    current = current.getLeft();
                    continue;
                } else {
                    mostRight.setRight(null);
                }
            }
            answer.add(current.getValue());
            current = current.getRight();
        }

        return answer;
    }
}
