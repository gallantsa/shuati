package 二叉树._30删除二叉搜索树中的节点._450_删除二叉搜索树中的节点;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        /*在root的值等于key的前提下*/
        if (root.val == key) {
            /*如果root的左子树为空, 直接返回根的右子树*/
            if (root.left == null) return root.right;
            /*同理*/
            else if (root.right == null) return root.left;
            /*否则, root的右子树上位(这里也可选择root的左子树上位)*/
            else {
                TreeNode cur = root.right;
                // 找到root的右子树中最左边的节点(值与root的值最接近)
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }

        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}