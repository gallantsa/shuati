package 回溯算法._16全排列II._47_全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
}

class Solution {
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();
    // 经典树层去重, 树枝不去重, 用used数组标记使用过的元素
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, 0);
        return result;
    }

    private void backTrack(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            // 树层去重, 树枝不去重
            // 如果同一树层nums[i]使用过, 则跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;

            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backTrack(nums, startIndex);
                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }
}