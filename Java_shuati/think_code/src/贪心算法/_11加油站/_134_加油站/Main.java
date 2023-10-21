package 贪心算法._11加油站._134_加油站;

public class Main {
}

class Solution {
    // 贪心算法
    // 局部最优解: 当前和小于0, 则更新起始位置, 并且当前和置为0
    // 全局最优解: 起始位置
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 如果数组长度为1, 则返回0
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            // 如果当前和小于0, 则更新起始位置, 并且当前和置为0
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        // 如果总和小于0, 则返回-1
        if (totalSum < 0) return -1;
        return start;
    }
}
