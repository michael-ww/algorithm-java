package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {

    public List<Integer> postorderTraversal1(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        this.postorderTraversal(root, answer);
        return answer;
    }

    private void postorderTraversal(TreeNode<Integer> tn, List<Integer> answer) {
        if (tn == null) {
            return;
        }
        this.postorderTraversal(tn.getLeft(), answer);
        this.postorderTraversal(tn.getRight(), answer);
        answer.add(tn.getValue());
    }

    public List<Integer> postorderTraversal2(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode<Integer> tn = stack1.pop();
            stack2.push(tn);
            if (tn.getLeft() != null) {
                stack1.push(tn.getLeft());
            }
            if (tn.getRight() != null) {
                stack1.push(tn.getRight());
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode<Integer> tn = stack2.pop();
            answer.add(tn.getValue());
        }

        return answer;
    }

    public List<Integer> postorderTraversal3(TreeNode<Integer> root) {
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
                    this.printReversingRightEdge(current.getLeft(), answer);
                }
            }
            current = current.getRight();
        }

        this.printReversingRightEdge(root, answer);
        return answer;
    }

    private void printReversingRightEdge(TreeNode<Integer> tn, List<Integer> answer) {
        TreeNode<Integer> tail = this.reverseRightEdge(tn);
        TreeNode<Integer> current = tail;
        while (current != null) {
            answer.add(current.getValue());
            current = current.getRight();
        }
        this.reverseRightEdge(tail);
    }

    private TreeNode<Integer> reverseRightEdge(TreeNode<Integer> tn) {
        TreeNode<Integer> current = tn, next, previous = null;
        while (current != null) {
            next = current.getRight();
            current.setRight(previous);
            previous = current;
            current = next;
        }

        return previous;
    }
}
