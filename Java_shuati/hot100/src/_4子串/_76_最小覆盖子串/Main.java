package _4子串._76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

// TODO _76_最小覆盖子串 待理解
class Solution {
    // 滑动窗口
    public String minWindow(String s, String t) {
        // need 表示需要的字符及其数量
        Map<Character, Integer> need = new HashMap<>();
        // window 表示窗口中的字符及其数量
        Map<Character, Integer> window = new HashMap<>();

        // 初始化 need
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        // 初始化窗口
        int left = 0, right = 0;
        // valid 表示窗口中满足 need 条件的字符数量
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 扩大窗口
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;

            // 进行窗口内数据的一系列更新
            // 如果 c 是需要的字符, 那么更新窗口
            if (need.containsKey(c)) {
                // 更新窗口
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口中 c 的数量等于需要的数量, 那么 valid++
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            // 当 valid == need.size() 时, 说明窗口中已经包含了所有需要的字符
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                // 如果 d 是需要的字符, 那么更新窗口
                if (need.containsKey(d)) {
                    // 如果窗口中 d 的数量等于需要的数量, 那么 valid--
                    if (window.get(d).equals(need.get(d)))
                        valid--;

                    // 更新窗口
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}