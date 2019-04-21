package leetcode;

/**
 * 9.
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */
/**
 *
 * Created by kaiscript on 2019/4/18.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int temp = x;
        int ret = 0;
        for (; x != 0; x/=10) {
            ret = ret * 10 + x % 10;
        }
        return temp == ret && temp >= 0;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-121));
    }

}
