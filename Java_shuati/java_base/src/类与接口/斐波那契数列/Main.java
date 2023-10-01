package 类与接口.斐波那契数列;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
