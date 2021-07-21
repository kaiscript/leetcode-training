package leetcode.stringAndArray;

public class StrStr1 {

    public static void main(String[] args) {
        StrStr1 s = new StrStr1();
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(s.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        int k = 0;
        for (int i = 0; i < haystack.length();) {
            k = i;
            for (int j = 0; j < needle.length(); ) {
                if (i >= haystack.length()) {
                    break;
                }
                if (haystack.charAt(i) != needle.charAt(j)) {
                    i++;
                    break;
                }
                if (j == needle.length() - 1) {
                    return k;
                }
                i++;
                j++;

            }
        }
        return -1;
    }

}
