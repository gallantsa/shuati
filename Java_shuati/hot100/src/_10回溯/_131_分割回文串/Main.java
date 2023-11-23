package _10回溯._131_分割回文串;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    // 记录结果
    List<List<String>> res = new LinkedList<>();

    // 记录路径
    List<String> track = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    // 回溯算法主框架
    private void backtrack(String s, int start) {
        // 如果起始位置等于字符串长度, 说明已经找到一组结果
        if (start == s.length()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 如果不是回文串, 直接跳过
            if (!isPalindrome(s, start, i)) continue;

            // 否则将子串加入路径
            track.add(s.substring(start, i + 1));
            backtrack(s, i + 1);
            track.remove(track.size() - 1);
        }
    }

    /**
     * 判断s的子串[start, end]是否为回文串
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;

        return true;
    }
}