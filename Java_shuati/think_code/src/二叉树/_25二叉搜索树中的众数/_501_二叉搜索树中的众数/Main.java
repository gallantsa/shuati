package 二叉树._25二叉搜索树中的众数._501_二叉搜索树中的众数;

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
    List<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        traversal(root);

        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /*还是中序遍历*/
    private void traversal(TreeNode cur) {
        if (cur == null) return;
        /*左*/
        traversal(cur.left);

        if (pre == null) count = 1;
        else if (pre.val == cur.val) count ++;
        else count = 1;

        /*中*/
        pre = cur;
        if (count == maxCount) resList.add(cur.val);
        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(cur.val);
        }
        /*右*/
        traversal(cur.right);
    }
}