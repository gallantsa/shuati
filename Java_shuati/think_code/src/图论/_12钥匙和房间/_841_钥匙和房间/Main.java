package 图论._12钥匙和房间._841_钥匙和房间;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    // 有向图搜索全路径, 只能用深搜或者广搜
    private void dfs(int key, List<List<Integer>> rooms, List<Boolean> visited) {
        if (visited.get(key)) {
            return;
        }
        visited.set(key, true);
        for (int k : rooms.get(key)) {
            // 深度优先搜索遍历
            dfs(k, rooms, visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 使用匿名内部类和双括号初始化语法来创建一个ArrayList对象
        List<Boolean> visited = new ArrayList<Boolean>(){{
            for(int i = 0 ; i < rooms.size(); i++){
                add(false);
            }
        }};
        // 从0号房间开始遍历
        dfs(0, rooms, visited);
        // 检查是否都访问到了
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
