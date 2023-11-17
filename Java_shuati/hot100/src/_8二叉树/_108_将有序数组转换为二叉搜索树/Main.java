package _8二叉树._108_将有序数组转换为二叉搜索树;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        // 因为数组是有序的, 所以每次都选择中间位置左边的数字作为根节点
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode((nums[mid]));

        // 构建左右子树
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);

        return root;
    }
}
