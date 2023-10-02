package 二叉树._3二叉树的迭代遍历._145_二叉树的后序遍历;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);

            if (pop.left != null) stack.add(pop.left);
            if (pop.right != null) stack.add(pop.right);
        }
        Collections.reverse(result);
        return result;
    }
}
