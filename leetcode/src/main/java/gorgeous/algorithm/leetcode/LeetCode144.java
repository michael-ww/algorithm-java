package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode144 {

    public List<Integer> preorderTraversal1(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        this.preorderTraversal11(root, answer);
        return answer;
    }

    private void preorderTraversal11(TreeNode<Integer> tn, List<Integer> answer) {
        if (tn == null) {
            return;
        }
        answer.add(tn.getValue());
        this.preorderTraversal11(tn.getLeft(), answer);
        this.preorderTraversal11(tn.getRight(), answer);
    }

    public List<Integer> preorderTraversal2(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> tn = stack.pop();
            answer.add(tn.getValue());
            if (tn.getRight() != null) {
                stack.push(tn.getRight());
            }
            if (tn.getLeft() != null) {
                stack.push(tn.getLeft());
            }
        }

        return answer;
    }

    public List<Integer> preorderTraversal3(TreeNode<Integer> root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        TreeNode<Integer> current = root;
        while (current != null) {
            TreeNode<Integer> mostRigth = current.getLeft();
            if (mostRigth == null) {
                answer.add(current.getValue());
            } else {
                while (mostRigth.getRight() != null && mostRigth.getRight() != current) {
                    mostRigth = mostRigth.getRight();
                }
                if (mostRigth.getRight() == null) {
                    answer.add(current.getValue());
                    mostRigth.setRight(current);
                    current = current.getLeft();
                    continue;
                } else {
                    mostRigth.setRight(null);
                }
            }
            current = current.getRight();
        }

        return answer;
    }
}
