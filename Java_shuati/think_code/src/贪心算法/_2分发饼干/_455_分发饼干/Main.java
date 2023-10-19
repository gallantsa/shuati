package 贪心算法._2分发饼干._455_分发饼干;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 优先考虑胃口, 大饼干优先喂饱胃口大的孩子
    // g是孩子, s是饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        // index 为饼干下标
        int index = s.length - 1;
        // i 为孩子下标
        for (int i = g.length - 1; i >= 0; i--) {
            // 如果当前饼干能喂饱当前孩子, 则饼干下标和孩子下标都减一
            if (index >= 0 && s[index] >= g[i]) {
                index --;
                sum ++;
            }
        }
        return sum;
    }
}