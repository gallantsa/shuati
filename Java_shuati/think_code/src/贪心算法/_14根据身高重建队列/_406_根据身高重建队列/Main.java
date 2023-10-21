package 贪心算法._14根据身高重建队列._406_根据身高重建队列;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            // 如果身高相同, 按照k升序排列
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            // 否则按照身高降序排列
            else return o2[0] - o1[0];
        });
        // 重新插入
        LinkedList<int[]> que = new LinkedList<>();

        for (int[] person : people) {
            que.add(person[1], person);
        }
        // toArray(T[] a)将队列转换为指定类型的数组
        // 这里是将队列转换为二维数组, []的数量为数组的维数, que.size()为数组的长度即行数
        return que.toArray(new int[que.size()][]);
    }
}