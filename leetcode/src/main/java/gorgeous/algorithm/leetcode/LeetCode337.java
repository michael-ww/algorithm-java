package gorgeous.algorithm.leetcode;

public class LeetCode337 {

    public int rob(TreeNode<Integer> root) {
        int[] yesno = this.postorder(root);
        return Math.max(yesno[0], yesno[1]);
    }

    private int[] postorder(TreeNode<Integer> root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = postorder(root.getLeft());
        int[] right = postorder(root.getRight());
        int yes = root.getValue() + left[1] + right[1];
        int no = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{yes, no};
    }
}
