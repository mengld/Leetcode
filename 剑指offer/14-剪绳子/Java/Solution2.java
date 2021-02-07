class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
        return dp[n];
    }
}

/*
边界条件：dp[1] = dp[2] = 1，表示长度为 2 的绳子最大乘积为 1；
状态转移方程：dp[i] = max(dp[i], max((i - j) * j, j * dp[i - j]))，可以这样理解
从j处剪，分两种情况，1.从j处剪开，剪下的部分是i-j，i-j不再剪了  2.从j处剪开，剪下的部分是i-j，i-j继续剪
*/
