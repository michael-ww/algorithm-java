package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode572 {

    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {

            return isSameTree(root, subRoot) || isSubtree1(root.getLeft(), subRoot) || isSubtree1(root.getRight(), subRoot);
        }
        return subRoot == null;
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null) {
            return root.getValue() == subRoot.getValue() && isSameTree(root.getLeft(), subRoot.getLeft()) && isSameTree(root.getRight(), subRoot.getRight());
        }
        return false;
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            List<String> rs = new ArrayList<>();
            List<String> ss = new ArrayList<>();
            serialize(root, rs);
            serialize(subRoot, ss);
            return kmp(rs, ss) != -1;
        }

        return subRoot == null;
    }

    private void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
        } else {
            list.add(String.valueOf(root.getValue()));
            serialize(root.getLeft(), list);
            serialize(root.getRight(), list);
        }
    }

    private int kmp(List<String> rs, List<String> ss) {
        if (rs == null || ss == null || rs.size() < ss.size()) {
            return -1;
        }
        int[] next = getNext(ss);
        int rsIndex = 0, ssIndex = 0;
        while (rsIndex < rs.size() && ssIndex < ss.size()) {
            if (ssIndex == -1 || rs.get(rsIndex).equals(ss.get(ssIndex))) {
                rsIndex++;
                ssIndex++;
            } else {
                ssIndex = next[ssIndex];
            }
        }

        return ssIndex == ss.size() ? rsIndex - ss.size() : -1;
    }

    private int[] getNext(List<String> ss) {
        int[] next = new int[ss.size()];
        next[0] = -1;
        next[1] = 0;
        int nextIndex = 2, comparedIndex = 0;
        while (nextIndex < ss.size()) {
            if (ss.get(nextIndex - 1).equals(ss.get(comparedIndex))) {
                next[nextIndex++] = ++comparedIndex;
            } else if (comparedIndex > 0) {
                comparedIndex = next[comparedIndex];
            } else {
                next[nextIndex++] = 0;
            }
        }
        return next;
    }
}
