package leetcode.stringAndArray;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama".toLowerCase()));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        StringBuilder sb = new StringBuilder();
        while(i <= j){
            char c1 = s.charAt(i);
            if (Character.isLetterOrDigit(c1)) {
                sb.append(c1);
            }
            i++;
        }
        String s1 = sb.toString();
        i = 0;
        j = s1.length() - 1;
        while (i < j) {
            char c1 = s1.charAt(i);
            char c2 = s1.charAt(j);
            if (c1 != c2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
