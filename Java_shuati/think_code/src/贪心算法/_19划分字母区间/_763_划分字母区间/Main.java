package 贪心算法._19划分字母区间._763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        int hash[] = new int[26];
        // 记录每个字母最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 更新当前区间的右边界
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            // 如果当前位置等于当前字母最后出现的位置, 则说明当前位置是一个分割点
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}