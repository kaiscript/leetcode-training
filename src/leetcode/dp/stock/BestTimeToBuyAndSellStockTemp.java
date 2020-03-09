package leetcode.dp.stock;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyAndSellStockTemp {

    /**
     * dp[i][j]: 第i天的利润，j=0 持有现金，j=1，持有股票
     * 转移方程：
     * dp[i][0] = max(dp[i-1][1] +prices[i],dp[i-1][0]) //昨天持有股票，今天卖了 或者 昨天持有现金，今天不操作
     * dp[i][1] = max(dp[i-1][0] -prices[i],-prices[i]) //因为只有一次交易，所以买进只有一次。昨天持有股票，今天不操作；或者 昨天误操作，今天买进
     *
     * base case:
     *  dp[0][0] = 0;
     *  dp[0][1] = -prices[0]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockTemp bst = new BestTimeToBuyAndSellStockTemp();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bst.maxProfit(prices));

    }

}
