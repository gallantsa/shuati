package _8二叉树._199_二叉树的右视图;

import _8二叉树.TreeNode;

import java.util.ArrayList;
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
    List<Integer> res = new ArrayList<>();

    // DFS
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    // 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
    // 与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;

        dfs(root.right, depth);
        dfs(root.left, depth);
    }

    // BFS
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> level = new LinkedList<>();
            // 只保留每一层的最后一个节点
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
            }
            res.add(level.get(level.size() - 1));
        }
        return res;
    }
}
