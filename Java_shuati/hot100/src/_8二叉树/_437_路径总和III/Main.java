package _8二叉树._437_路径总和III;

import _8二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    int t;
    // 这里用long类型, 因为可能会溢出
    long ans;

    // 本体关键理解题意中路径方向必须是向下的
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        dfs1(root);
        return (int)ans;
    }

    // 用于遍历整个二叉树
    private void dfs1(TreeNode root) {

        if (root == null) return;

        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    // 负责从当前节点向下遍历
    private void dfs2(TreeNode root, long val) {
        if (val == t) ans++;

        if (root.left != null) dfs2(root.left, val + root.left.val);
        if (root.right != null) dfs2(root.right, val + root.right.val);
    }
}

// 前缀和的思路不太好理解
class Solution2 {
    // 哈希表用于存储路径和及其出现次数
    Map<Long, Integer> map = new HashMap<>();
    // 用于记录满足条件的路径数量
    int ans, t;

    // 本体关键理解题意中路径方向必须是向下的
    public int pathSum(TreeNode root, int targetSum) {
        // 如果根节点为空，返回 0
        if (root == null) return 0;
        // 将给定的目标值赋给变量 t
        t = targetSum;
        // 初始化哈希表，路径和为 0 的初始次数设为 1
        map.put(0L, 1);
        // 开始深度优先搜索
        dfs(root, root.val);
        // 返回满足条件的路径数量
        return ans;
    }

    // 深度优先搜索方法
    void dfs(TreeNode root, long val) {
        // 检查是否存在路径和为 (val - t) 的键，如果存在，则增加满足条件的路径数量
        if (map.containsKey(val - t)) ans += map.get(val - t);
        // 更新当前路径和 val 在哈希表中的出现次数，若不存在则放入哈希表，存在则增加其次数
        map.put(val, map.getOrDefault(val, 0) + 1);
        // 递归处理左子树，并更新路径和 val
        if (root.left != null) dfs(root.left, val + root.left.val);
        // 递归处理右子树，并更新路径和 val
        if (root.right != null) dfs(root.right, val + root.right.val);
        // 回溯：完成一条路径的搜索后，将当前路径和 val 在哈希表中的次数减去 1
        // 这样可以在回退到上一层时不影响其他路径的计算
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}