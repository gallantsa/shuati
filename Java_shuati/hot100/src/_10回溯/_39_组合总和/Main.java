package _10回溯._39_组合总和;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;

        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主框架
    private void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和, 直接结束
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 将数字加入路径
            track.add(candidates[i]);
            // 递归
            backtrack(candidates, i, target, sum + candidates[i]);
            // 回溯
            track.removeLast();
        }
    }
}