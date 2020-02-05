package leetcode;

/**
 *
 * 9. Palindrome Number
 *
 *  回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    /**
     * 转为字符串的做法
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 反转全部数字
     * @param x
     * @return
     */
    public boolean isPalindrome0(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int ret = 0;
        for (; x > 0; x /= 10) {
            ret = ret * 10 + x % 10;
        }
        return ret == temp;
    }

    /**
     * 只反转一半的数字，防止反转后的数字超过MAX溢出
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        //x == num / 10 是为了判断x是奇数长度的场景
        return num == x || x == num / 10;
    }

    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome1(-10));
        System.out.println(ip.isPalindrome1(121));
    }

}
