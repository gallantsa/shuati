package 哈希表._2有效的字母异位词._242有效的字母异位词;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int num: record) {
            if (num != 0) return false;
        }
        return true;
    }
}