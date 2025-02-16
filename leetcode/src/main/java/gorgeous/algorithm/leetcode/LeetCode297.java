package gorgeous.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode297 {

    public String preorderSerialize(TreeNode<Integer> root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        this.preorderSerialize(root, sb);
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    private void preorderSerialize(TreeNode<Integer> treeNode, StringBuilder sb) {
        if (treeNode == null) {
            sb.append("null,");
        } else {
            sb.append(treeNode.getValue()).append(",");
            this.preorderSerialize(treeNode.getLeft(), sb);
            this.preorderSerialize(treeNode.getRight(), sb);
        }
    }

    public TreeNode<Integer> preorderDeserialize(String data) {
        String[] items = data.substring(1, data.length() - 1).split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(items));
        return this.preorderDeserialize(queue);
    }

    private TreeNode<Integer> preorderDeserialize(Queue<String> queue) {
        String item = queue.poll();
        if (item.equals("null")) {
            return null;
        } else {
            TreeNode<Integer> treeNode = new TreeNode<>(Integer.valueOf(item));
            treeNode.setLeft(this.preorderDeserialize(queue));
            treeNode.setRight(this.preorderDeserialize(queue));
            return treeNode;
        }
    }

    public String postorderSerialize(TreeNode<Integer> root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        this.postorderSerialize(root, sb);
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    private void postorderSerialize(TreeNode<Integer> root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            this.postorderSerialize(root.getLeft(), sb);
            this.postorderSerialize(root.getRight(), sb);
            sb.append(root.getValue()).append(",");
        }
    }

    public TreeNode<Integer> postorderDeserialize(String data) {
        String[] items = data.substring(1, data.length() - 1).split(",");
        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(items));
        return this.postorderDeserialize(stack);
    }

    private TreeNode<Integer> postorderDeserialize(Stack<String> stack) {
        String item = stack.pop();
        if (item.equals("null")) {
            return null;
        } else {
            TreeNode<Integer> root = new TreeNode<>(Integer.valueOf(item));
            root.setRight(this.postorderDeserialize(stack));
            root.setLeft(this.postorderDeserialize(stack));
            return root;
        }
    }

    public String levelSerialize(TreeNode<Integer> root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        sb.append("[");
        while (!queue.isEmpty()) {
            TreeNode<Integer> tn = queue.poll();
            if (tn == null) {
                sb.append("null,");
            } else {
                sb.append(tn.getValue()).append(",");
                queue.offer(tn.getLeft());
                queue.offer(tn.getRight());
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    public TreeNode<Integer> levelDeserialize(String data) {
        String[] items = data.substring(1, data.length() - 1).split(",");
        Queue<String> queueItems = new LinkedList<>(Arrays.asList(items));
        String item = queueItems.poll();
        TreeNode<Integer> root = new TreeNode<>(Integer.valueOf(item));
        Queue<TreeNode<Integer>> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode<Integer> parent = treeNodes.poll();
            String left = queueItems.poll();
            if (!left.equals("null")) {
                TreeNode<Integer> leftNode = new TreeNode<>(Integer.valueOf(left));
                parent.setLeft(leftNode);
                treeNodes.offer(leftNode);
            }
            String right = queueItems.poll();
            if (!right.equals("null")) {
                TreeNode<Integer> rightNode = new TreeNode<>(Integer.valueOf(right));
                parent.setRight(rightNode);
                treeNodes.offer(rightNode);
            }
        }
        return root;
    }
}
