package leetcode.stringAndArray.windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAllAnagramsInAString {

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
