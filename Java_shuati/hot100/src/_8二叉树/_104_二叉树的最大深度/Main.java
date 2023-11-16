package _8二叉树._104_二叉树的最大深度;

import _8二叉树.TreeNode;

public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 动态规划
    public int maxDepth1(TreeNode root) {
        if (null == root) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    // 回溯
    int depth = 0;
    int res = 0;
    public int maxDepth2(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        depth++;
        res = Math.max(res, depth);

        traverse(root.left);
        traverse(root.right);

        depth--;
    }
}