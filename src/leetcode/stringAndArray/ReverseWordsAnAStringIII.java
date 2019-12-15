package leetcode.stringAndArray;

/**
 * 557
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsAnAStringIII {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && i != chars.length - 1) {
                continue;
            } else {
                reverseWord(chars, j, i == chars.length - 1 ? chars.length - 1 : i - 1);
                j = i + 1;
            }
        }
        return new String(chars);
    }

    public void reverseWord(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        ReverseWordsAnAStringIII rs = new ReverseWordsAnAStringIII();
        System.out.println(rs.reverseWords(str));
    }

}
