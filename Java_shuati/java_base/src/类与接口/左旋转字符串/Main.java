package 类与接口.左旋转字符串;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String leftRotateString(String str,int n) {
        str = str.substring(n, str.length()) + str.substring(0, n);
        return str;
    }
}
