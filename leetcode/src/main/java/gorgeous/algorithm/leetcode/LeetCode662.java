package gorgeous.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode662 {

    public int widthOfBinaryTree(TreeNode<Integer> root) {
        int answer = 0;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(new Entry(root, 1));
        while (!queue.isEmpty()) {
            int leftIndex = Integer.MAX_VALUE, rightIndex = Integer.MIN_VALUE;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Entry entry = queue.poll();
                leftIndex = Math.min(leftIndex, entry.getIndex());
                rightIndex = Math.max(rightIndex, entry.getIndex());
                if (entry.getTreeNode().getLeft() != null) {
                    queue.offer(new Entry(entry.getTreeNode().getLeft(), entry.getIndex() * 2));
                }
                if (entry.getTreeNode().getRight() != null) {
                    queue.offer(new Entry(entry.getTreeNode().getRight(), entry.getIndex() * 2 + 1));
                }
            }
            answer = Math.max(answer, rightIndex - leftIndex + 1);
        }
        return answer;
    }

    private static class Entry {

        private final TreeNode<Integer> treeNode;
        private final Integer index;

        public Entry(TreeNode<Integer> treeNode, Integer index) {
            this.treeNode = treeNode;
            this.index = index;
        }

        public TreeNode<Integer> getTreeNode() {
            return treeNode;
        }

        public Integer getIndex() {
            return index;
        }
    }
}
