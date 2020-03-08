package leetcode.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChangeTemp {

    /**
     * 状态： dp[i] : 金额为i时，至少需要多少个硬币
     * 状态转移方程： dp[i] = min(dp[i],dp[i-coin]+1)
     * 由于是求最小值，故先填充数组（ Arrays.fill(dp, amount + 1); ），作标识以判断出是否算出结果
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeTemp coinChangeTemp = new CoinChangeTemp();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChangeTemp.coinChange(coins, 11));
    }

}
