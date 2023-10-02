package 二叉树._11完全二叉树的节点个数._222_完全二叉树的节点个数;

import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            while (len -- > 0) {
                TreeNode node = queue.poll();
                result ++;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}