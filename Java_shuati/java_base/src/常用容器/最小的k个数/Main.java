package 常用容器.最小的k个数;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public List<Integer> getLeastNumbers_Solution(int[] input, int k) {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(input);
        int i = 0;
        while (k-- != 0) {
            list.add(input[i++]);
        }
        return list;
    }
}