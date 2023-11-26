package _14贪心算法._763_划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    // 贪心算法
    // 构造一个数组，存放给定字符串s中，每个字符最后出现的索引
    // 设置两个指针start和end分别表示符合要求的片段的开始索引和结束索引
    // 按字符遍历字符串，不断更新end的值，直到i == end说明已经搜寻到一个符合要求的片段了，此时重置start的值
    public List<Integer> partitionLabels(String s) {

        // 1. 定义结果集
        List<Integer> res = new ArrayList<>();

        // 2. 定义每个字符最后出现的位置
        int[] last = new int[26];

        // 3. 遍历字符串, 更新每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // 4. 定义左右指针
        int left = 0;
        int right = 0;

        // 5. 遍历字符串
        for (int i = 0; i < s.length(); i++) {

            // 6. 更新右指针
            right = Math.max(right, last[s.charAt(i) - 'a']);

            // 7. 如果左右指针相等, 说明找到了一个划分区间
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }

        return res;
    }
}