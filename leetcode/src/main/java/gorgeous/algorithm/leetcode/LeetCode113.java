package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        this.pathSum(root, targetSum, answer, new LinkedList<>());
        return answer;
    }

    private void pathSum(TreeNode<Integer> root, int left, List<List<Integer>> answer, LinkedList<Integer> path) {
        path.addLast(root.getValue());
        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getValue() == left) {
                answer.add(new ArrayList<>(path));
            }
        } else {
            if (root.getLeft() != null) {
                this.pathSum(root.getLeft(), left - root.getValue(), answer, path);
            }
            if (root.getRight() != null) {
                this.pathSum(root.getRight(), left - root.getValue(), answer, path);
            }
        }
        path.removeLast();
    }
}
