package gorgeous.algorithm.leetcode;

public class LeetCode110 {

    public boolean isBalanced(TreeNode<Integer> root) {
        return this.isBalancedTree(root).isBalanced;
    }

    private BalanceInfo isBalancedTree(TreeNode<Integer> root) {
        if (root == null) {
            return new BalanceInfo(0, true);
        }
        BalanceInfo leftBalancedInfo = this.isBalancedTree(root.getLeft());
        BalanceInfo rightBalancedInfo = this.isBalancedTree(root.getRight());
        int height = Math.max(leftBalancedInfo.height, rightBalancedInfo.height) + 1;
        boolean isBalanced = leftBalancedInfo.isBalanced && rightBalancedInfo.isBalanced && Math.abs(leftBalancedInfo.height - rightBalancedInfo.height) < 2;
        return new BalanceInfo(height, isBalanced);
    }

    public class BalanceInfo {

        public int height;
        public boolean isBalanced;

        public BalanceInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
