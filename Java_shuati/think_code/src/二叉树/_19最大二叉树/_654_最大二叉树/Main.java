package 二叉树._19最大二叉树._654_最大二叉树;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildHelper(nums, 0, nums.length);
    }

    private TreeNode buildHelper(int[] nums, int leftIndex, int rightIndex) {
        /*如果没有元素了, 返回null*/
        if (rightIndex - leftIndex  < 1) return null;
        /*如果只有一个元素了, 返回该元素节点*/
        if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);

        /*找最大值, 以及其下标*/
        int maxVal = nums[leftIndex];
        int maxIndex = leftIndex;
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        /*划分左右子树*/
        root.left = buildHelper(nums, leftIndex, maxIndex);
        root.right = buildHelper(nums, maxIndex + 1, rightIndex);

        return root;
    }
}