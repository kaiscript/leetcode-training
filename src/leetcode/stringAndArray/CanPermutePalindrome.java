package leetcode.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class CanPermutePalindrome {

    /**
     * 字母排列为回文。那么回文字符串2种情况：1.字符串偶数长度，偶数个字符;2.字符串奇数长度，除了中间的字符，其余字符是偶数个。
     * 那么就是求字符是否是偶数个，或者奇数的字符是不是只有一个
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int index = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                continue;
            }
            else
                index++;
        }
        return index <= 1;
    }

}
