package 贪心算法._20合并区间._56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        // 先按照左边界升序排列
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的左边界大于前一个区间的右边界, 则说明当前区间和前一个区间没有交集
            if (intervals[i][0] > end) {
                // 将前一个区间加入结果集
                res.add(new int[]{start, end });
                // 更新当前区间的左右边界
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                // 如果当前区间的左边界小于前一个区间的右边界, 则说明当前区间和前一个区间有交集, 更新当前区间的右边界
                end = Math.max(end, intervals[i][1]);
            }
        }
        // 将最后一个区间加入结果集
        res.add(new int[]{start, end });
        return res.toArray(new int[res.size()][]);
    }
}