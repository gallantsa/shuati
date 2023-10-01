package 常用容器.数字在排序数组中出现的次数;

public class Main {

}

class Solution {
    public int getNumberOfK(int[] nums, int k) {
        int cnt = 0;
        for(int num : nums) {
            if (num == k) cnt++;
        }
        return cnt;
    }
}
