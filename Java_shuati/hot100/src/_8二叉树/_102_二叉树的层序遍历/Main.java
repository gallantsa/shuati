package _8二叉树._102_二叉树的层序遍历;

import _8二叉树.TreeNode;

import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 保存每一层的节点值
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
}