package leetcode.stringAndArray;

/**
 * 67.
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 * Created by kaiscript on 2019/10/15.
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        //��־λ
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int result = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int abit = i >= 0 ? Character.getNumericValue(a.charAt(i--)) : 0;
            int bbit = j >= 0 ? Character.getNumericValue(b.charAt(j--)) : 0;
            //���õ����
            result = abit ^ bbit ^ carry;
            //�ж��Ƿ���Ҫ��λ
            carry = (abit + bbit + carry) >= 2 ? 1 : 0;
            sb.append(result);
        }
        return sb.reverse().toString();
    }

}
