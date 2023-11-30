package _2023._11._30_._1657_确定两个字符串是否接近;

import java.util.Arrays;

public class Main   {
}

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // 如果count1[i]和count2[i]都为0，说明两个字符串都不包含字符i
            if (count1[i] + count2[i] == 0) {
                continue;
            }

            // 上一个if语句保证了count1[i]和count2[i]不同时为0
            if (count1[i] == 0 || count2[i] == 0) {
                return false;
            }
        }

        // 对count1和count2进行排序
        Arrays.sort(count1);
        Arrays.sort(count2);

        // 如果count1和count2不相等，说明两个字符串包含的字符种类不同
        if (!Arrays.equals(count1, count2)) {
            return false;
        }

        return true;
    }
}