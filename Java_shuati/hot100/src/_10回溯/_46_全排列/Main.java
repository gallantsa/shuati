package _10回溯._46_全排列;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    // 记录结果
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录是否使用过
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 如果路径长度等于数组长度, 说明已经找到一组结果
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 遍历每一个数字
        for (int i = 0; i < nums.length; i++) {
            // 如果数字已经使用过, 直接跳过
            if (used[i]) continue;

            // 否则将数字加入路径, 并标记为已使用
            track.add(nums[i]);
            used[i] = true;

            // 递归
            backtrack(nums, track, used);

            // 回溯
            track.removeLast();
            used[i] = false;
        }
    }
}