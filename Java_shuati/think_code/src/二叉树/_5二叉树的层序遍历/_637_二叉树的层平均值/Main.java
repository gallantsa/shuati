package 二叉树._5二叉树的层序遍历._637_二叉树的层平均值;

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
    public List<Double> averageOfLevels(TreeNode root) {
        /*结果集*/
        List<Double> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            /*len限制二叉树每一层的节点个数*/
            int len = queue.size();
            int size = len;

            while (len -- > 0) {
                TreeNode node = queue.poll();
                itemList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            /*注意这里用long*/
            long sum = 0;
            for (Integer integer : itemList) {
                sum += integer;
            }
            double v = sum * 1.0 / size ;
            resList.add(v);
        }
        return resList;
    }
}
