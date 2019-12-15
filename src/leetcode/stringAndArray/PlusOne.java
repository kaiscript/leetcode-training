package leetcode.stringAndArray;

/**
 *66.
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 * Created by kaiscript on 2019/10/13.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9};
//        int[] nums = {1,2,3};
        for (int i : plusOne(nums)) {
            System.out.print(i);
        }
    }

    public int[] plusOne0(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //plus one
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //如果都是9的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
