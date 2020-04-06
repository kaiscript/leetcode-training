package leetcode.dance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWords {

    public String reverseWord(String str) {
        String split = split(str);
        return reverseW(split);
    }

    /**
     * 去掉首尾空格，并且是单词中间的空格只有一个
     * @param s
     * @return
     */
    public String split(String s) {
        int left = 0;
        int right = s.length() - 1;
        //去掉首尾空格
        while (left <= right && s.charAt(left) == ' ')
            left++;
        while (left <= right && s.charAt(right) == ' ')
            right--;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            }
            //结果的末尾没有空格则加字符，为了使空格只有一个
            else if(sb.charAt(sb.toString().length()-1)!=' ')
                sb.append(c);
            left++;
        }
        return sb.toString();

    }

    /**
     * 遍历规整好的字符串。寻找单词，再逆序输出
     * @param str
     * @return
     */
    public String reverseW(String str) {
        int left = 0;
        int right = 0;
        List<String> ret = new ArrayList<>();
        while (right < str.length()) {
            if (str.charAt(right) == ' ') {
                ret.add(str.substring(left, right));
                left = right + 1;
                right = left;
            }
            if (right == str.length() - 1) {
                ret.add(str.substring(left));
            }
            right++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ret.size() - 1; i >= 0; i--) {
            sb.append(ret.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWord("  hello world!  "));
    }

}
