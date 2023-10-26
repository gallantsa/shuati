package 动态规划._31打家劫舍III._337_打家劫舍III;

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
    // 状态标记递归
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
    // Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    // 后序遍历
    int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;

        // 获取左右子树的状态
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // 不偷
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}