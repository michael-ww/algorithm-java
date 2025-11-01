package gorgeous.algorithm.leetcode;

public class LeetCode104 {

    public int maxDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
