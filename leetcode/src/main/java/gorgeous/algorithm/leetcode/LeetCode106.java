package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode106 {

    public TreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length <= 0 || postorder == null || postorder.length <= 0 || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx++) {
            map.put(inorder[idx], idx);
        }
        return this.il(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode<Integer> il(int[] inorder, int il, int ir, int[] postorder, int pl, int pr, Map<Integer, Integer> map) {
        if (il > ir || pl > pr) {
            return null;
        }
        TreeNode<Integer> head = new TreeNode<>(postorder[pr]);
        int find = map.get(postorder[pr]);
        head.setLeft(this.il(inorder, il, find - 1, postorder, pl, pl + find - il - 1, map));
        head.setRight(this.il(inorder, find + 1, ir, postorder, pl + find - il, pr - 1, map));
        return head;
    }
}
