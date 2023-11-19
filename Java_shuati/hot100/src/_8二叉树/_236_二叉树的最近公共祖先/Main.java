package _8二叉树._236_二叉树的最近公共祖先;

import _8二叉树.TreeNode;

public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 函数定义: 返回以root为根节点的子树中, p和q的最近公共祖先
        if (root == null) return null;
        if (root == q || root == p) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        return left == null ? right : left;
    }
}