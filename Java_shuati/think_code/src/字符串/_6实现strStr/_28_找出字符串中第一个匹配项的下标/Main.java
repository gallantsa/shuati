package 字符串._6实现strStr._28_找出字符串中第一个匹配项的下标;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
    }
}
//Todo: KMP实现
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                int m = i + j;
                if (haystack.charAt(m) != needle.charAt(j)) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
