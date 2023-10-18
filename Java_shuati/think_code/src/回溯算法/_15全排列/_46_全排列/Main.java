package 回溯算法._15全排列._46_全排列;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println("lists = " + lists);
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if(path.size() == nums.length) result.add(new ArrayList<>(path));

        // 因为树的宽度和深度都是nums.length, 所以这里不需要终止条件, 且i都是从0开始
        for (int i = startIndex; i < nums.length; i++) {
            // 树枝不去重, 树层去重
            // 如果当前元素已经在path中, 则跳过
            if (path.contains(nums[i])) continue;

            path.add(nums[i]);
            backTracking(nums, startIndex);
            path.remove(path.size() - 1);
        }
    }
}