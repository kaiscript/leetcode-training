package leetcode.dfsbfs;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 127. Word Ladder
 * Medium
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 维护一个 连接图
        Map<String, List<String>> map = new HashMap<>();
        int length = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String match = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = map.getOrDefault(match, new ArrayList<>());
                list.add(word);
                map.put(match, list);
            }
        }

        Queue<Mark> queue = new LinkedBlockingQueue<>();
        Map<String, Boolean> visited = new HashMap<>();

        queue.add(new Mark(beginWord, 1));
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Mark mark = queue.poll();
            String w = mark.word;
            int level = mark.level;
            for (int i = 0; i < length; i++) {
                String match = w.substring(0, i) + "*" + w.substring(i + 1, length);
                List<String> list = map.getOrDefault(match, new ArrayList<>());
                for (String node : list) {
                    //找到匹配的单词了
                    if (endWord.equals(node)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(node)) {
                        visited.put(node, true);
                        queue.add(new Mark(node, level + 1));
                    }
                }

            }

        }
        return 0;
    }

    class Mark{
        String word;
        int level;

        public Mark(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(wl.ladderLength("hit", "cog", list));
    }

}
