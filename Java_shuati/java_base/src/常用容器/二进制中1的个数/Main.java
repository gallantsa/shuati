package 常用容器.二进制中1的个数;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int NumberOf1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++ )
            res += n >> i & 1;
        return res;
    }
}