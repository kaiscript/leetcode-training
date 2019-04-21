package leetcode;

/**
 * 7.Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output:  321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 *
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

 /**
 * Created by chenkai on 2019/4/18.
 */
public class ReverseInteger {

    public int reverseInteger(int x) {
        long ret = 0;
        for (; x != 0; x /= 10) {
            ret = ret * 10 + x % 10;
        }
        return ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ? 0 : (int) ret;
    }

     public static void main(String[] args) {
         ReverseInteger reverseInteger = new ReverseInteger();
         System.out.println(reverseInteger.reverseInteger(-123));
     }

}
