package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode617 {

    public TreeNode<Integer> mergeTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode<Integer> root = new TreeNode<>(root1.getValue() + root2.getValue());
        root.setLeft(this.mergeTrees(root1.getLeft(), root2.getLeft()));
        root.setRight(this.mergeTrees(root1.getRight(), root2.getRight()));
        return root;
    }
}
