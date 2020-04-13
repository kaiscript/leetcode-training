package leetcode.stringAndArray;

import java.util.HashSet;
import java.util.Set;

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
