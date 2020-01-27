package leetcode.stringAndArray.windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 *
 *  找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAllAnagramsInAString {

    /**
     *  需要的窗口 needs
     *  当前的窗口 windows
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int match = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {

            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            if (needs.containsKey(c)) {
                if (windows.getOrDefault(c, 0).intValue() == needs.getOrDefault(c, 0).intValue()) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left == p.length()) {
                    result.add(left);
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    int num = windows.getOrDefault(c2, 0).intValue() - 1;
                    windows.put(c2, num);
                    if (num < needs.getOrDefault(c2, 0).intValue()) {
                        match--;
                    }
                }
                left++;
            }
        }

        return result;
    }

}
