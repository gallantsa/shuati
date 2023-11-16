package _8二叉树._94_二叉树的中序遍历;

import _8二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
    }
}