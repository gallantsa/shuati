package _1哈希._49_字母异位词分组;

import java.util.*;

public class Main {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            // 将字符串排序, 作为key
            char[] chars = temp.toCharArray();
            // 对字符数组进行排序!!!
            Arrays.sort(chars);
            // 将字符数组转换为字符串
            String key = String.valueOf(chars);
            // 如果map中已经有了这个key, 就将当前字符串加入到对应的list中
            if (map.containsKey(key)) {
                map.get(key).add(temp);
            } else {
                // 如果没有这个key, 就新建一个list, 并且将当前字符串加入到list中
                List<String> li = new ArrayList<>();
                li.add(temp);
                map.put(key, li);
            }
        }
        // 将map中的所有value放入list中
        return new ArrayList<>(map.values());
    }
}