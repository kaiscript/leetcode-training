package leetcode.stringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 345.
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                String substring = s.substring(index, i);
                if (!substring.isEmpty()) {
                    index = i;
                    list.add(substring);
                }
                index++;
            }
            if (i == s.length() - 1) {
                String substring = s.substring(index, s.length());
                if (!substring.isEmpty()) {
                    index = i;
                    list.add(substring);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "  hello world!  ";
        String str1 = "a good   example";
        String str2 = "   ";
        ReverseWordsInAString rs = new ReverseWordsInAString();
//        System.out.println(rs.reverseWords(str));
//        System.out.println(rs.reverseWords(str1));
        String s = rs.reverseWords(str1);
        System.out.println(s);
        System.out.println(s.length());

    }

}
