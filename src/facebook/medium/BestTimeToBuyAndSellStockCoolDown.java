package facebook.medium;

/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 */

public class BestTimeToBuyAndSellStockCoolDown
{
    public int maxProfit( int[] prices )
    {
        if ( prices == null || prices.length == 0 ) 
        {
            return 0;
        }
        
        // 表示当天最终未持股的情况下，当天结束后的累计最大利润
        int[] sellDp = new int[prices.length];
        // 表示当天最终持股的情况下，当天结束后的累计最大利润
        int[] buyDp = new int[prices.length];
        
        // 考虑初始情况
        buyDp[0] = -prices[0];
        sellDp[0] = 0;
        for (int i = 1; i < prices.length; i++) 
        {
            sellDp[i] = Math.max( sellDp[i - 1], buyDp[i - 1] + prices[i] );
            if (i >= 2) 
            {
                buyDp[i] = Math.max( buyDp[i - 1], sellDp[i - 2] - prices[i] );
            }
            else 
            {
                buyDp[i] = Math.max( buyDp[i - 1], -prices[i] );
            }
        }
        return sellDp[prices.length - 1];
    }
}
