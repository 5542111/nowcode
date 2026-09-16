package com.luwis.code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class a0543diameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        treeDepth(root, diameter);
        return diameter[0];
    }

    private int treeDepth(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        int left = treeDepth(node.left, diameter);
        int right = treeDepth(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTreeIterative(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> depth = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int diameter = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !depth.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !depth.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int left = depth.getOrDefault(node.left, 0);
                int right = depth.getOrDefault(node.right, 0);
                diameter = Math.max(diameter, left + right);
                depth.put(node, Math.max(left, right) + 1);
            }
        }
        return diameter;
    }
}
