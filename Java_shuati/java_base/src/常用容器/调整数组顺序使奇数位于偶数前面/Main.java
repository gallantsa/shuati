package 常用容器.调整数组顺序使奇数位于偶数前面;

public class Main {
    public static void main(String[] args) {


    }
}
class Solution {
    public void reOrderArray(int[] array) {
        int i  = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && array[i] % 2 == 1) i++;
            while (i < j && array[j] % 2 == 0) j--;
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
    }
}