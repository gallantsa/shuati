package _8二叉树._226_翻转二叉树;

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
    // 遍历的思路
    // 从根节点开始, 对每一层的节点进行翻转
    public TreeNode invertTree1(TreeNode root) {
        traverse(root);
        return root;
    }

    // 函数定义：翻转每个节点的左右子树
    // 这里是前序遍历
    private void traverse(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
    }

    // 分解问题的思路
    // 从最后一层开始, 对每一层的节点进行翻转, 返回翻转后的二叉树的根节点
    // 后序遍历
    public TreeNode invertTree2(TreeNode root) {
        // 定义: 将以root为根节点的二叉树翻转, 返回翻转后的二叉树的根节点
        if (root == null) return null;

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}