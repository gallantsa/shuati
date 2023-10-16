package 回溯算法._7组合总和._39_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 5};
        List<List<Integer>> lists = solution.combinationSum(candidates, 8);
        System.out.println("lists = " + lists);
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex) {
        // sum 控制深度
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        // i 控制宽度
        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) break;
            path.addLast(candidates[i]); // 这里有个坑, 如果这里使用push, 下面就要使用pop, 如果这里使用addLast, 下面就要使用removeLast
            backTracking(candidates, target, sum + candidates[i], i); // 这里仍然传入i是因为元素可以重复使用
            path.removeLast();
        }
    }
}