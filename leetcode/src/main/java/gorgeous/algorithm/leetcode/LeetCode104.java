package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode104 {

    public int maxDepth(TreeNode<Integer> root) {
        return root == null ? 0 : Math.max(this.maxDepth(root.getLeft()), this.maxDepth(root.getRight())) + 1;
    }
}
