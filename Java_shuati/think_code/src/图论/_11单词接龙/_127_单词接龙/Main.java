package 图论._11单词接龙._127_单词接龙;

import java.util.*;

public class Main {
}

// 无向图求最短路, 一般使用广搜
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将wordList放入HashSet中, 方便查找
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;

        // 广搜队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // 记录每个单词的步数
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        // 广搜
        while (!queue.isEmpty()) {
            // 取出队首单词
            String word = queue.poll();
            // 取出当前单词的步数
            int path = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] ch = word.toCharArray();
                // 将当前单词的每个字母都替换成26个字母
                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;
                    String newWord = String.valueOf(ch);
                    // 如果新单词等于endWord, 就返回当前步数+1
                    if (newWord.equals(endWord)) return path + 1;
                    // 如果新单词在wordSet中, 并且没有被访问过, 就将新单词加入队列, 并且记录新单词的步数
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        // 将新单词加入队列
                        queue.offer(newWord);
                        // 记录新单词的步数
                        map.put(newWord, path + 1);
                    }
                }
            }
        }
        return 0;
    }
}