package 贪心算法._18无重叠区间._435_无重叠区间;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 先按照左边界升序排列
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int res = 0;
        // 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的左边界小于前一个区间的右边界, 则需要移除当前区间
            if (intervals[i][0] < intervals[i - 1][1]) {
                res++;
                // 如果当前区间的右边界大于前一个区间的右边界, 则当前区间的右边界为前一个区间的右边界
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return res;
    }
}