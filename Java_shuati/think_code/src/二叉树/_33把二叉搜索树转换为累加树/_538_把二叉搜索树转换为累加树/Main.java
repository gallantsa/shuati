package 二叉树._33把二叉搜索树转换为累加树._538_把二叉搜索树转换为累加树;

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
    private int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) return;

        // 右
        traversal(cur.right);
        // 中
        cur.val += pre;
        pre = cur.val;
        // 左
        traversal(cur.left);
    }
}