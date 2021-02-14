class Solution {
    public int numWays(int n) {

        if (n == 0)
            return 1;
        if (n <= 2)
            return n;

        int a = 2, b = 1;
        int res = 0;
        for (int i = 3; i <= n; i ++) {
            res = (a + b) % 1000000007;
            b = a;
            a = res;
        }

        return res;
    }
}
