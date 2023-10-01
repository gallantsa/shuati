package 类与接口.求1加2加n;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(10));
    }
}

class Solution {
    public int getSum(int n) {
        int res = n;
        boolean flag = n > 0 && (res += getSum(n - 1)) > 0;
        return res;
    }
}
