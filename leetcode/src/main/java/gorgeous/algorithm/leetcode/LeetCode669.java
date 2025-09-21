package gorgeous.algorithm.leetcode;

public class LeetCode669 {

    public TreeNode trimBST(TreeNode<Integer> root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.getValue() < low) {
            return this.trimBST(root.getRight(), low, high);
        }
        if (root.getValue() > high) {
            return this.trimBST(root.getLeft(), low, high);
        }
        root.setLeft(this.trimBST(root.getLeft(), low, high));
        root.setRight(this.trimBST(root.getRight(), low, high));
        return root;
    }
}
