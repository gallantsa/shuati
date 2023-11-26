package _15动态规划._118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {

    public List<List<Integer>> generate(int numRows) {

        // 1. 定义结果集
        List<List<Integer>> res = new ArrayList<>();

        // 2. 定义第一行
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        // 3. 遍历行
        for (int i = 1; i < numRows; i++) {

            // 4. 定义当前行
            List<Integer> curRow = new ArrayList<>();

            // 5. 获取上一行
            List<Integer> preRow = res.get(i - 1);

            // 6. 遍历当前行
            for (int j = 0; j <= i; j++) {

                // 7. 如果是第一个元素或者最后一个元素, 直接添加1
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    // 8. 否则, 添加上一行的两个元素之和
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }

            // 9. 将当前行添加到结果集中
            res.add(curRow);
        }

        return res;
    }
}