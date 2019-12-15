package leetcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Medium
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), result);
        return result;

    }

    public void dfs(int startIndex, String s, List<String> palindrome, List<List<String>> result) {

        if (startIndex == s.length()) {
            result.add(new ArrayList<>(palindrome));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //每次选取 [startIndex,i+1)范围的字符串判断是否回文，是的话进入下一个dfs，否则i++，再次判断是否回文
            String str = s.substring(startIndex, i + 1);
            if(!isPalindrome(str))
                continue;

            palindrome.add(str);
            dfs(i + 1, s, palindrome, result);
            palindrome.remove(palindrome.size() - 1);
        }

    }

    public boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aab"));
    }

}
