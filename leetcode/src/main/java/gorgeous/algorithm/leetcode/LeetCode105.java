package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode105 {

    public TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null || inorder.length <= 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx++) {
            map.put(inorder[idx], idx);
        }
        return this.buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode<Integer> buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir, Map<Integer, Integer> map) {
        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode<Integer> head = new TreeNode<>(preorder[pl]);
        int find = map.get(preorder[pl]);
        head.setLeft(this.buildTree(preorder, pl + 1, pl + find - il, inorder, il, find - 1, map));
        head.setRight(this.buildTree(preorder, pl + find - il + 1, pr, inorder, find + 1, ir, map));
        return head;
    }
}
