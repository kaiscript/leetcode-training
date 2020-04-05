package leetcode.dance.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        Map<Character, Integer> windows = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            Integer count = windows.get(c);
            while (count > 1) {
                char sc = s.charAt(start);
                windows.put(sc, windows.getOrDefault(sc, 0) - 1);
                count = windows.getOrDefault(c, 0);
                start++;
            }
            end++;
            int dis = end - start;
            max = dis > max ? dis : max;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "dvdf";
        String str1 = "bbbbb";
        String str2 = "pwwkew";
        LengthOfLongestSubstring lol = new LengthOfLongestSubstring();
        System.out.println(lol.lengthOfLongestSubstring(str));
        System.out.println(lol.lengthOfLongestSubstring(str1));
        System.out.println(lol.lengthOfLongestSubstring(str2));
    }

}
