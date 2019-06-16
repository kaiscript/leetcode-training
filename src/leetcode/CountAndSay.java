package leetcode;

/**
 * 38.
 * Description
 The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.

 11 is read off as "two 1s" or 21.

 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 Tags: String
 * Created by kaiscript on 2019/6/16.
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0){
            int times = 1;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            char[] chars = str.toCharArray();
            for (int j = 1; j < length; j++) {
                if (chars[j] == chars[j - 1]) {
                    times++;
                }
                else{
                    sb.append(times).append(chars[j-1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[length - 1]).toString();
        }
        return str;
    }



}
