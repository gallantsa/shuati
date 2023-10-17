package 回溯算法._10复原IP地址._93_复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; // 算是剪枝了
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        // 逗点数量为3时, 分隔结束
        if (pointNum == 3) {
            // 判断第四段子字符串是否合法, 如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                // 可用StringBuilder的insert方法优化
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backTrack(s, i + 2, pointNum);
                pointNum--;
                // 回溯删掉逗点
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    // TODO 更优化的版本
}