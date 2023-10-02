package 二叉树._8对称二叉树._101_对称二叉树;

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
// TODO 利用迭代法重新实现
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        /*左为空, 右不为空*/
        if(left == null && right != null) return false;

        /*左不为空, 右为空*/
        if(left != null && right == null) return false;

        /*左为空, 右为空*/
        if(left == null && right == null) return true;

        /*左不为空, 右不为空, 但值不相等*/
        if(left.val != right.val) return false;

        /*比较外侧*/
        boolean outside = compare(left.left, right.right);

        /*比较内侧*/
        boolean inside = compare(left.right, right.left);

        return outside && inside;
    }
}