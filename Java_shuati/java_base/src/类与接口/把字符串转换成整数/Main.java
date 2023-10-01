package 类与接口.把字符串转换成整数;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int sign = 1;
        char first = str.charAt(0);
        if (first == '+' || first == '-') {
            if (first == '-') sign = -1;
            str = str.substring(1);
        }

        long res = 0;
        for (char c: str.toCharArray()) {
            if (c < '0' || c > '9') break;
            int x = c - '0';
            res = res * 10 + x;
            if (res > 1e11) break;
        }

        res *= sign;

        if (res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) res = Integer.MIN_VALUE;

        return (int)res;
    }
}