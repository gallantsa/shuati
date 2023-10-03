package 二叉树._15左叶子之和._404_左叶子之和;

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
    public int sumOfLeftLeaves(TreeNode root) {
        /*递归出口*/
        if (root == null) return 0;

        /*计算根节点左子树的左叶子之和*/
        int leftValue = sumOfLeftLeaves(root.left);
        /*计算根节点右子树的左叶子之和*/
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        /*如果当前节点的左孩子不为空, 且为叶子结点, 就累加*/
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        /*最终结果*/
        int sum = leftValue + midValue + rightValue;
        return sum;
    }
}