package _3滑动窗口._3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;

        // left和right是左闭右开区间
        while (right < s.length()) {
            // 移动右指针
            char c = s.charAt(right);
            right++;
            // 更新哈希表, 记录当前字符出现的次数
            hash.put(c, hash.getOrDefault(c, 0) + 1);

            // 如果当前字符出现的次数大于1, 说明当前窗口中出现了重复字符
            // 移动左指针, 直到当前窗口中没有重复字符
            // 为什么移动左指针不会漏掉最长子串? 因为如果当前窗口中出现了重复字符, 那么移动左指针, 一定会移除一个重复字符
            while (hash.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                hash.put(d, hash.get(d) - 1);
            }

            // 更新结果
            res = Math.max(res, right - left);
        }
        return res;
    }
}