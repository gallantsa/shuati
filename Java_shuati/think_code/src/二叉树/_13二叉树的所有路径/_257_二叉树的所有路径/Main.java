package 二叉树._13二叉树的所有路径._257_二叉树的所有路径;

import 二叉树.TreeNode;

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
    public List<String> binaryTreePaths(TreeNode root) {
        /*结果集*/
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        /*存放路径*/
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);

        return res;
    }

    /*前序遍历解法*/
    private void traversal(TreeNode root, List<Integer> path, List<String> res) {
        /*为什么不把递归出口放在最前面?*/
        /*因为终止条件是到叶子节点, 在退出之前需将叶子结点的值保存*/
        /*中*/
        path.add(root.val);

        if (root.left == null && root.right == null) {
            /*将路径转换成字符串的逻辑*/
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        /*左*/
        if (root.left != null) {
            traversal(root.left, path, res);
            /*回溯*/
            path.remove(path.size() - 1);
        }
        /*右*/
        if (root.right != null) {
            traversal(root.right, path, res);
            /*回溯*/
            path.remove(path.size() - 1);
        }
    }
}