package leetcode.dp;

/**
 * 516. 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubsequence {

    /**
     * 状态：
     * dp[i][j] : 从i到j的回文子序列的长度
     * 状态转移方程:
     * dp[i][j] = dp[i+1][j-1] + 2 , if str[i]==str[j]
     * dp[i][j] = max(dp[i+1][j],dp[i][j-1]) , if str[i]!=str[j]
     * dp[i][j] = 1, if i==j
     *
     * base case:
     * i 必定小于 j
     * dp[0][j] = 0
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        //dp[i][j] = max(dp[i+1][j],dp[i][j-1]) , if str[i]!=str[j]
        //dp[i][j] = dp[i+1][j-1] + 2 , if str[i]==str[j]
        //dp[i][j]的值来自于dp[i+1][j](下),dp[i][j-1](左),dp[i+1][j-1](左下)
        //故必须反正遍历。i从n-1开始遍历，n-1是为了防止数组越界
        for (int i = n - 1; i >= 0; i--) {
            //i 必定小于 j
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);

            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.longestPalindromeSubseq("bbbab"));
    }

}
