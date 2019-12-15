package leetcode.stringAndArray;

/**
 * 28.
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Clarification:

 What should we return when needle is an empty string? This is a great question to ask during an interview.

 For the purpose of this problem, we will return 0 when needle is an empty string.
 This is consistent to C's strstr() and Java's indexOf().
 * Created by kaiscript on 2019/10/15.
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr0("mississippi", "issi"));
    }

    public int strStrSimple(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    public static int strStr0(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }

        for (int i = 0; i < l1; i++) {
            if (i + l2 > l1) {
                break;
            }
            for (int j = 0; j < l2; j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == l2 - 1) {
                    return i;
                }
            }
        }
        return -1;
    }


}
