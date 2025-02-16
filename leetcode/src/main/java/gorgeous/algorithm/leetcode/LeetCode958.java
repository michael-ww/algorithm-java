package gorgeous.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode958 {

    public boolean isCompleteTree(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode<Integer> tn = queue.poll();
            if ((tn.getLeft() == null && tn.getRight() != null) || (leaf && (tn.getLeft() != null || tn.getRight() != null))) {
                return false;
            }
            if (tn.getLeft() != null) {
                queue.offer(tn.getLeft());
            }
            if (tn.getRight() != null) {
                queue.offer(tn.getRight());
            }
            if (tn.getLeft() == null || tn.getRight() == null) {
                leaf = true;
            }
        }

        return true;
    }
}
