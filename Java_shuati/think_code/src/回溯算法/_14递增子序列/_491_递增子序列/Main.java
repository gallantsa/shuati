package 回溯算法._14递增子序列._491_递增子序列;

import java.util.*;

public class Main {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if(path.size() >= 2) result.add(new ArrayList<>(path));

        // 这里的set只会作用于当前树层, 不会作用于树枝
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {

            // 树枝不去重, 树层去重
            // 如果当前元素小于path中的最后一个元素, 或者当前元素已经在path中, 则跳过
            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i])) continue;

            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}