package 回溯算法._4组合总和III._216_组合总和III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 0, 1);
        return result;
    }

    // 未剪枝版
    // k 控制树的深度
    private void backTracking(int targetSum, int k, int sum, int startIndex) {
        if (path.size() == k)
            if (targetSum == sum)
                result.add(new ArrayList<>(path));

        // startIndex控制树的宽度
        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.push(i);
            backTracking(targetSum, k, sum, i + 1);
            path.pop();
            sum -= i;
        }
    }

    // 剪枝版
    private void backTracking2(int targetSum, int k, int sum, int startIndex) {
        // 剪枝1
        // 如果当前元素和大于目标和, 直接返回
        if (sum > targetSum) return;
        if (path.size() == k)
            if (targetSum == sum)
                result.add(new ArrayList<>(path));

        // 剪枝2
        // 如果剩余元素个数不足, 直接减去
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.push(i);
            backTracking(targetSum, k, sum, i + 1);
            path.pop();
            sum -= i;
        }
    }
}