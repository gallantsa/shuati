package 二叉树._18从中序与后序遍历序列构造二叉树._105_从前序与中序遍历序列构造二叉树;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return buildHelper(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int inorderStart,
                                 int inorderEnd, int[] preorder, int preorderStart, int preorderEnd) {
        if (preorderStart >=  preorderEnd) return null;
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);

        /*找中序数组的根节点坐标*/
        int middleIndex;
        for (middleIndex = 0; middleIndex < inorderEnd; middleIndex++) {
            if (rootVal == inorder[middleIndex]) break;
        }

        /*分割中序数组*/
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        /*分割前序数组*/
        int leftPreorderStart = preorderStart + 1;
        int leftPreorderEnd = leftPreorderStart + (middleIndex - inorderStart);
        int rightPreorderStart = leftPreorderEnd;
        int rightPreorderEnd = preorderEnd; // 注意边界

        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, preorder, leftPreorderStart,
                leftPreorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, preorder, rightPreorderStart,
                rightPreorderEnd);

        return root;
    }
}