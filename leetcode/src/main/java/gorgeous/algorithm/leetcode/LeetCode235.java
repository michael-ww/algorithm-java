package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode235 {

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p.getValue() > root.getValue() && q.getValue() > root.getValue()) {
            return this.lowestCommonAncestor(root.getRight(), p, q);
        } else if (p.getValue() < root.getValue() && q.getValue() < root.getValue()) {
            return this.lowestCommonAncestor(root.getLeft(), p, q);
        } else {
            return root;
        }
    }
}
