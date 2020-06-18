package leetcode.stringAndArray;

import java.util.HashSet;
import java.util.Set;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;

        for (char c : chars) {
            if (!set.add(c)) {
                count++;
                set.remove(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("abccccdd"));

    }

}
