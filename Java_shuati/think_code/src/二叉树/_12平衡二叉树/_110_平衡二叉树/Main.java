package 二叉树._12平衡二叉树._110_平衡二叉树;

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
    public boolean isBalanced(TreeNode root) {

        return getHeight(root) != -1;
    }

    /*如果不是平衡二叉树, 返回-1*/
    private int getHeight(TreeNode node) {
        /*如果节点为空，节点高度为0*/
        if (node == null) return 0;

        /*如果节点左子树不是平衡二叉树，说明整颗树不是平衡二叉树返回-1*/
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        /*同上*/
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;

        int result;
        /*如果节点左右子树高度差的绝对值大于1，说明该树不是平衡二叉树， 返回-1, 否则返回该节点的高度*/
        if(Math.abs(rightHeight - leftHeight) > 1) return -1;
        else result = 1 + Math.max(rightHeight, leftHeight);

        return result;
    }
}
