package _2023._12._2._1094_拼车;

public class Main {
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 用数组记录每个地点的乘客数量
        int[] count = new int[1001];
        // 遍历trips，统计每个地点的乘客数量
        for (int[] trip : trips) {
            // 上车地点增加乘客数量
            count[trip[1]] += trip[0];
            // 下车地点减少乘客数量
            count[trip[2]] -= trip[0];
        }

        // 遍历count，统计每个地点的乘客数量
        for (int i = 0; i < count.length; i++) {
            // 如果当前地点的乘客数量大于capacity，返回false
            if (count[i] > capacity) {
                return false;
            }
            // 统计当前地点的乘客数量
            capacity -= count[i];
        }

        return true;
    }
}