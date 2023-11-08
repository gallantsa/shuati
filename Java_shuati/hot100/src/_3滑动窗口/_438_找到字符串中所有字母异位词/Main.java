package _3滑动窗口._438_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            // 移动右指针
            char c = s.charAt(right);
            right++;
            // 更新窗口
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            // 如果当前窗口中某个字符的数量大于需要的数量, 那么就要收缩窗口
            while (window.get(c) > need.getOrDefault(c, 0)) {
                char d = s.charAt(left);
                left++;
                // 更新窗口
                window.put(d, window.get(d) - 1);
            }

            // 判断是否找到了合法的子串
            if (right - left == p.length()) {
                res.add(left);
            }
        }
        return res;
    }
}