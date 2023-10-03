package 二叉树._16找树左下角的值._513_找树左下角的值;

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
    int max_Depth = Integer.MIN_VALUE;
    int depth;
    int result;

    /*依然层序遍历, 记录每一层的值后, 返回最后一层的第一个元素*/
    public int findBottomLeftValue1(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while (len-- > 0) {
                TreeNode node = queue.poll();
                itemList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resList.add(itemList);
        }
        Collections.reverse(resList);
        return resList.get(0).get(0);
    }

    /*递归实现*/
    public int findBottomLeftValue2(TreeNode root) {
        traversal(root, depth);
        return result;
    }

    private void traversal(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > max_Depth) {
                max_Depth = depth;
                result = root.val;
            }
        }

        if (root.left != null) {
            depth++;
            traversal(root.left, depth);
            depth--;
        }

        if (root.right != null) {
            depth++;
            traversal(root.right, depth);
            depth--;
        }
    }
}