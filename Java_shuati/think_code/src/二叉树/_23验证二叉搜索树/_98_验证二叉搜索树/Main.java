package 二叉树._23验证二叉搜索树._98_验证二叉搜索树;

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
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        /*左*/
        boolean left = isValidBST(root.left);
        if (!left) return false;

        /*这里为什么要等于?*/
        /*因为这里max节点是root的左子树中值最大的节点, 存在的话就必须小于root的值*/
        /*中*/
        if (max != null && max.val >= root.val) return false;
        max = root;

        /*右*/
        boolean right = isValidBST(root.right);
        /*这里直接返回right是因为root和root的左子树已经判断完了, 只要root的右子树也符合规则, 该树就是二叉搜索树*/
        return right;
    }
}