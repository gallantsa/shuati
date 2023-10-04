package 二叉树._17路径总和._113_路径总和II;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    }

    private void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            preorderdfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);// 回溯
        }

        if (root.right != null) {
            preorderdfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }
}