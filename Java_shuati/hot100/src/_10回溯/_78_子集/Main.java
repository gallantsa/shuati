package _10回溯._78_子集;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    // 记录结果
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        // 每次都将路径加入结果
        res.add(new LinkedList<>(track));

        // 遍历每一个数字
        for (int i = start; i < nums.length; i++) {
            // 将数字加入路径
            track.add(nums[i]);
            // 递归
            backtrack(nums, i + 1, track);
            // 回溯
            track.removeLast();
        }
    }
}