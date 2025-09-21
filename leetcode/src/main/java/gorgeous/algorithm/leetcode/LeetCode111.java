package gorgeous.algorithm.leetcode;

public class LeetCode111 {

    public int minDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (root.getLeft() != null) {
            left = this.minDepth(root.getLeft());
        }
        if (root.getRight() != null) {
            right = this.minDepth(root.getRight());
        }
        return Math.min(left, right) + 1;
    }
}
