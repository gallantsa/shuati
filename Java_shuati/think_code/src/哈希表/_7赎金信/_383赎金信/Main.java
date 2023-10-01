package 哈希表._7赎金信._383赎金信;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = ransomNote.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: chars) {
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                if (count != 0) {
                    count --;
                    map.put(ch, count);
                }
            }
        }
        for (char ch : chars) {
            if (map.get(ch) != 0) return false;
        }
        return true;
    }
}