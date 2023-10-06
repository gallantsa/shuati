package 二叉树._29二叉搜索树中的插入操作._701_二叉搜索树中的插入操作;

import sun.reflect.generics.tree.Tree;
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else if (root.val > val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}