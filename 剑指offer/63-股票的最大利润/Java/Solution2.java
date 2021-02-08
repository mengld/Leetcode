class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int maxProfit = 0;
        int buyPoint = prices[0];

        for (int i = 1; i < prices.length; i ++) {
            buyPoint = Math.min(buyPoint, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buyPoint);
        }

        return maxProfit;
    }
}
