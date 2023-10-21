package 贪心算法._17用最少数量的箭引爆气球._452_用最少数量的箭引爆气球;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        // 使用Integer.compare(o1[0], o2[0])比使用o1[0] - o2[0]效率更高, 不会溢出
        // 先按照左边界升序排列
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int res = 1;
        // 从第二个气球开始遍历
        for (int i = 1; i < points.length; i++) {
            // 如果当前气球的左边界大于前一个气球的右边界, 则需要一支箭
            if (points[i][0] > points[i - 1][1]) res++;
            // 如果当前气球的右边界小于前一个气球的右边界, 则当前气球的右边界为前一个气球的右边界
            else points[i][1] = Math.min(points[i][1], points[i - 1][1]);
        }
        return res;
    }
}