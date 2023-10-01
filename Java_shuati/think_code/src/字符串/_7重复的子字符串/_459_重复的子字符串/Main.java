package 字符串._7重复的子字符串._459_重复的子字符串;

public class Main {
}

// Todo 9-9 00:11
// 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            String substring = s.substring(0, i + 1);
            StringBuffer stringBuffer = null;
            for (int j = 0; j <= s.length() / substring.length(); j++) {
                stringBuffer = new StringBuffer();
                stringBuffer.append(substring);
            }
            if (stringBuffer.toString().equals(s)) return true;
        }
        return false;
    }
}