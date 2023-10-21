package 贪心算法._13柠檬水找零._860_柠檬水找零;

public class Main {
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int bill : bills) {
            // 如果是5元, 则5元的数量加一
            if (bill == 5) {
                five ++;
            }
            // 如果是10元, 则10元的数量加一, 并且5元的数量减一
            else if (bill == 10) {
                ten ++;
                five --;
            }
            // 如果是20元, 则优先使用10元和5元的组合, 如果没有10元, 则使用3个5元
            else {
                if (ten > 0) {
                    ten --;
                    five --;
                    twenty++;
                } else {
                    five -= 3;
                }
            }
            // 如果5元的数量小于0, 则返回false
            if (five < 0) return false;
        }
        return true;
    }
}