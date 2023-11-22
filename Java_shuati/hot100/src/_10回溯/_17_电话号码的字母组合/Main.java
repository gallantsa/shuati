package _10回溯._17_电话号码的字母组合;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    // 映射表
    String[] mapping = new String[]{
      "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (null == digits || 0 == digits.length()) return res;

        // 从digits的第0个数字开始
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int start, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // 遍历当前数字对应的所有字母
        for (int i = start; i < digits.length(); i++) {
            // 当前数字
            int digit = digits.charAt(i) - '0';

            for (char c : mapping[digit].toCharArray()) {
                sb.append(c);
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}