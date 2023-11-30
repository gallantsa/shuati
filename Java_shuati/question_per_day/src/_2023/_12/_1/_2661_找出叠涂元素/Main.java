package _2023._12._1._2661_找出叠涂元素;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // 用哈希表存储每个元素的坐标
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        // 遍历矩阵，将每个元素的坐标存入哈希表
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        // 统计每行、每列的元素个数
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];

        // 遍历数组，统计每行、每列的元素个数
        for (int i = 0; i < arr.length; ++i) {
            // 获取当前元素的坐标
            int[] v = map.get(arr[i]);
            ++rowCnt[v[0]];

            // 如果当前元素所在行的元素个数等于m，说明当前行已经填满
            if (rowCnt[v[0]] == m) {
                return i;
            }
            // 如果当前元素所在列的元素个数等于n，说明当前列已经填满
            ++colCnt[v[1]];
            if (colCnt[v[1]] == n) {
                return i;
            }
        }

        return -1;
    }
}