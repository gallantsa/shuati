package 哈希表._4快乐数._202快乐数;

import java.util.HashSet;
import java.util.Set;

public class Main {

}

class Solution {
    // 获得一个数的各个位数的平方和
    private int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1) return true;

            if(set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
    }
}