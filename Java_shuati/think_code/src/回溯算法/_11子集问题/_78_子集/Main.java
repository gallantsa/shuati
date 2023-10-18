package 回溯算法._11子集问题._78_子集;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        // 为什么在终止条件前加入结果集?
        // 因为要加入最后一次的结果
        result.add(new ArrayList<>(path));

        // 终止条件可不加
        if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            path.push(nums[i]);
            backTracking(nums, i + 1);
            path.pop();
        }
    }
}