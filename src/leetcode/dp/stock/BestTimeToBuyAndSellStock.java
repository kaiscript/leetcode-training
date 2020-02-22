package leetcode.dp.stock;

/**
 * 121. 买卖股票的最佳时机
 *
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 状态 dp[i][j] :
     * i 表示 第 i 天 当前的利润是多少
     * j =0 当前持有现金，不操作。j=1 当前拥有股票
     *
     * 状态转移方程：
     * //今天不操作 = 昨天不操作,今天不操作 或者 昨天有股票，今天卖了
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
     * //今天持有股票 = 昨天持有股票,今天不操作 或者 今天买进股票。由于本题只进行一次交易,所以买入股票的情况必定是第一次买入，即 0 - prices[i]
     * dp[i][1] = max(dp[i-1][1],0-prices[i])
     *
     * base case:
     * dp[0][0] = 0
     * dp[0][1] = -prices[0]
     *
     * //最后返回持有 现金的情况（也就是不持有股票的情况）
     *  dp[prices.length - 1][0]
     * @param prices
     * @return
     */
    public int maxProfitDp(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }
        //最后返回持有 现金的情况（也就是不持有股票的情况）
        return dp[prices.length - 1][0];
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if(diff > max){
                    max = diff;
                }
            }
        }
        return max;
    }

}
