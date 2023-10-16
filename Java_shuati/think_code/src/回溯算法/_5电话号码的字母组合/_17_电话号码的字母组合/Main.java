package 回溯算法._5电话号码的字母组合._17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {

    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        backTracking(digits, 0);
        return result;
    }

    // index 表示本层递归, 它所指向的数字的下标
    // digits控制树的深度
    private void backTracking(String digits, int index) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }

        // 这里将数码转换成int
        int digit = digits.charAt(index) - '0';
        // letter 表示当前数码对应的字符串
        String letter = numString[digit];
        // 这里不需要用startIndex进行去重操作
        // 因为是从不同集合取元素
        // i控制树的宽度
        for (int i = 0; i < letter.length(); i++) {
            temp.append(letter.charAt(i));
            backTracking(digits, index + 1); // 注意这里是 index + 1
            // 剔除末尾元素继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}