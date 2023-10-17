package 回溯算法._8组合总和II._40_组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];

        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);

        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        // sum 控制树的深度
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝, 因为主函数中数组已经排序, 如果同一层出现第一个sum大于target的分支, 则直接减去后面的所有分支
            if (sum + candidates[i] > target) break;

            // 树层去重
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            sum += candidates[i];
            path.push(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1); // 树枝去重, 去重的是相同的元素, 不同元素有相同的值的不算
            used[i] = false;
            sum -= candidates[i];
            path.pop();
        }
    }
}