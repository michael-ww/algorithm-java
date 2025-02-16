package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> item = queue.poll();
                if (leftToRight) {
                    level.addLast(item.getValue());
                } else {
                    level.addFirst(item.getValue());
                }
                if (item.getLeft() != null) {
                    queue.offer(item.getLeft());
                }
                if (item.getRight() != null) {
                    queue.offer(item.getRight());
                }
            }
            answer.add(level);
            leftToRight = !leftToRight;
        }

        return answer;
    }
}
