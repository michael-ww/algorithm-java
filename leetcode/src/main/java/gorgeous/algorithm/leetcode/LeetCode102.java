package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode102 {

    public List<List<Integer>> levelOrder1(TreeNode<Integer> root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode<Integer> item = queue.poll();
                level.add(item.getValue());
                if (item.getLeft() != null) {
                    queue.offer(item.getLeft());
                }
                if (item.getRight() != null) {
                    queue.offer(item.getRight());
                }
            }
            answer.add(level);
        }

        return answer;
    }

    public List<List<Integer>> levelOrder2(TreeNode<Integer> root) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode<Integer> currentLevelEnd = root, nextLevelEnd = null;
        while (!queue.isEmpty()) {
            TreeNode<Integer> item = queue.poll();
            level.add(item.getValue());
            if (item.getLeft() != null) {
                queue.offer(item.getLeft());
                nextLevelEnd = item.getLeft();
            }
            if (item.getRight() != null) {
                queue.offer(item.getRight());
                nextLevelEnd = item.getRight();
            }
            if (item == currentLevelEnd) {
                answer.add(new ArrayList<>(level));
                currentLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
                level.clear();
            }
        }

        return answer;
    }
}
