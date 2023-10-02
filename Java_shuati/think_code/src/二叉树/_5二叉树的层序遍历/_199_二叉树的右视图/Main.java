package 二叉树._5二叉树的层序遍历._199_二叉树的右视图;

import 二叉树.TreeNode;

import java.util.*;

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
// 解题思路: 层序遍历二叉树, 保存每一层的最后一个元素
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        /*结果集*/
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            /*len限制二叉树每一层的节点个数*/
            int len = queue.size();
            while (len -- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                /*保存每一层最后一个元素*/
                if (len == 0) result.add(node.val);
            }
        }
        return result;
    }
}