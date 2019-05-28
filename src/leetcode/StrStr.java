package leetcode;

/**
 * 28.
 * Created by kaiscript on 2019/5/28.
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l2 > l1) {
            return -1;
        }
        for (int i = 0;; i++) {
            if (i + l2 > l1) {
                return -1;
            }
            for (int j = 0;; j++) {
                if (j == l2) {
                    return i;
                }
                if (needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("aaaaa", "bba"));
    }

}
