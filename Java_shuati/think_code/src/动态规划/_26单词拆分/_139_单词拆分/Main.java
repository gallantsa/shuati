package 动态规划._26单词拆分._139_单词拆分;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 初始化
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        // 先遍历背包, 再遍历物品, 因为此题是求排列数, 对顺序有要求
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 先截取字符串, 从j 到 i
                String s1 = s.substring(j, i);
                // 如果 dp[j] 为 true, 且 set 中包含 s1, 则 dp[i] 为 true
                if (dp[j] && set.contains(s1)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}