class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int[] dp = new int[prices.length];
        int cost = prices[0];
        dp[0] = 0;

        for (int i = 1; i < prices.length; i ++) {
            cost = Math.min(cost, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i]-cost);
        }

        return dp[prices.length - 1];
    }
}
