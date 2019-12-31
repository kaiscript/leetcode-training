package leetcode.stringAndArray.windows;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        //初始化需要的字母次数
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int match = 0;
        //不断移动右指针直到符合条件
        while (right < s.length()) {
            char c = s.charAt(right);
            Integer count = windows.getOrDefault(c, 0).intValue() + 1;
            windows.put(c, count);
            if (needs.containsKey(c)) {
                if (needs.get(c).intValue() == windows.get(c).intValue()) {
                    match++;
                }
            }
            right++;
            //符合条件后移动左指针，求包含t的最小的字符串。当不符合条件时，则跳出移动左指针的循环。
            while (match == needs.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    Integer num = windows.get(c2).intValue() - 1;
                    windows.put(c2, num);
                    if (num < needs.get(c2).intValue()) {
                        match--;
                    }
                }
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen + 1);
    }

    public static void main(String[] args) {
        String s = "";
        String t = "";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }
}
