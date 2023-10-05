package 二叉树._22二叉搜索树中的搜索._700_二叉搜索树中的搜索;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        TreeNode result = null;
        if (root.val > val) result = searchBST(root.left, val);
        if (root.val < val) result = searchBST(root.right, val);
        return result;
    }
}