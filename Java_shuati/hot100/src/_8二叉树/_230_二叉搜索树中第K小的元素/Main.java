package _8二叉树._230_二叉搜索树中第K小的元素;

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

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank;

    public int kthSmallest(TreeNode root, int k) {
        // 利用BST的中序遍历特性
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (null == root) return;

        traverse(root.left, k);

        // 中序遍历代码位置
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}