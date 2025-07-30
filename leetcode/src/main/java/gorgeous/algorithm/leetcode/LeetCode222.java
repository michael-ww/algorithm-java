package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode222 {

    public int countNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = this.countHeight(root.getLeft());
        int rightHeight = this.countHeight(root.getRight());
        if (leftHeight == rightHeight) {
            return this.countNodes(root.getRight()) + (1 << leftHeight);
        } else {
            return this.countNodes(root.getLeft()) + (1 << rightHeight);
        }
    }

    private int countHeight(TreeNode<Integer> root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.getLeft();
        }
        return height;
    }
}
