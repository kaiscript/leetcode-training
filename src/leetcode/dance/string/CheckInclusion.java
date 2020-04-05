package leetcode.dance.string;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < length1; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        //c2 滑动窗口范围:[s1.length,s1.length+s2.length]
        for (int i = 0; i < length2 - length1; i++) {
            if (isMatch(c1, c2)) {
                return true;
            }
            c2[s2.charAt(i) - 'a']--;
            c2[s2.charAt(i + length1) - 'a']++;
        }
        return isMatch(c1, c2);
    }

    /**
     * 两区间包含的字符数是否相等
     * @param c1
     * @param c2
     * @return
     */
    public boolean isMatch(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dadc";
        CheckInclusion cil = new CheckInclusion();
        System.out.println(cil.checkInclusion(s1, s2));
    }

}
