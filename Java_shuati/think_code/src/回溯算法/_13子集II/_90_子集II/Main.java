package 回溯算法._13子集II._90_子集II;

import java.util.*;

public class Main {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序方便去重
        Arrays.sort(nums);
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

            // 树枝不去重, 树层去重
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.push(nums[i]);
            backTracking(nums, i + 1);
            path.pop();
        }
    }
}