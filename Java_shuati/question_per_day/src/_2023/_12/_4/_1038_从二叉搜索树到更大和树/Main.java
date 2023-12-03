package _2023._12._4._1038_从二叉搜索树到更大和树;



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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
            // 递归遍历二叉搜索树
            dfs(root);
            return root;
    }

    // 反向中序遍历二叉搜索树
    private void dfs(TreeNode root) {
            // 如果当前节点为空，返回
            if (root == null) {
                    return;
            }
            // 递归遍历右子树
            dfs(root.right);
            // 更新当前节点的值
            root.val += sum;
            // 更新sum
            sum = root.val;
            // 递归遍历左子树
            dfs(root.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}