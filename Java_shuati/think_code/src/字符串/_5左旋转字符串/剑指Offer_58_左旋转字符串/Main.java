package 字符串._5左旋转字符串.剑指Offer_58_左旋转字符串;

public class Main {
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}