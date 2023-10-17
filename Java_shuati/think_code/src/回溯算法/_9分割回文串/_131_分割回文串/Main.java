package 回溯算法._9分割回文串._131_分割回文串;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<String>> result = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    private void backTracking(String s, int startIndex) {
        // 如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(deque));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文子串, 则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                // 这里要使用add和remove, 不能使用push和pop, 暗示是队列操作而不是栈操作
                deque.addLast(str);
            } else {
                continue;
            }

            // 起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}