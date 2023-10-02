package 二叉树._5二叉树的层序遍历._107_二叉树的层序遍历II;

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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*结果集*/
        List<List<Integer>> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            /*len限制二叉树每一层的节点个数*/
            int len = queue.size();

            while (len -- > 0) {
                TreeNode node = queue.poll();
                itemList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add(itemList);
        }
        Collections.reverse(resList);
        return resList;
    }
}