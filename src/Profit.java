/**
 * @Description 股票最佳时期
 * @Author alice
 * @Date 2020/7/10 14:38
 **/
public class Profit {
    public int maxProfit1(int[] prices) {
        /**
         * @Description //如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
         * @Date 2020/7/10 14:39
         * @Param prices
         * @return int
         **/
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int max = dp[0];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1];
            min = Math.min(prices[i], min);
            if (prices[i] > min) {
                dp[i] = prices[i] - min;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        /**
         * @Description //设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
         * @Date  2020/7/10 14:41
         * @Param  * @param prices
         * @return int
         **/
        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public int maxProfit3(int[] prices){
        if (prices.length<=1){
            return 0;
        }
        int n=prices.length;
        int [][]dp=new int[n][3];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        for (int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);

    }
}
