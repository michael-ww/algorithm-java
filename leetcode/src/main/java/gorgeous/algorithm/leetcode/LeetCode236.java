package gorgeous.algorithm.leetcode;

public class LeetCode236 {

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode<Integer> left = this.lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode<Integer> right = this.lowestCommonAncestor(root.getRight(), p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
