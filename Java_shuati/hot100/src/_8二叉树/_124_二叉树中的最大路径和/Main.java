package _8二叉树._124_二叉树中的最大路径和;

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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        // 返回以root为根节点的子树中, 以root为起点的最大路径和
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int t = root.val;
        if (left >= 0) t += left;
        if (right >= 0) t += right;
        ans = Math.max(ans, t);
        return Math.max(left, right) >= 0 ? Math.max(left, right) + root.val : root.val;
    }
}