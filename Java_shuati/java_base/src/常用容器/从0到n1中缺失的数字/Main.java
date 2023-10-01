package 常用容器.从0到n1中缺失的数字;

public class Main {
}

class Solution {
    public int getMissingNumber(int[] nums) {
        int i = 0;
        for (int num: nums) {
            if(num != i) return i;
            else i++;
        }
        return i;
    }
}