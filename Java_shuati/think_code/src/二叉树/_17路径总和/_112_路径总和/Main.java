package 二叉树._17路径总和._112_路径总和;

import 二叉树.TreeNode;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) return true;
        }

        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) return true;
        }
        return false;
    }
}