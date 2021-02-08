class Solution {
    public double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        boolean isN = false;
        if (n < 0) {
            n = -n;
            isN = true;
        }
        double res = pow(x, n);

        return isN ? 1.0 / res : res;
    }

    private double pow(double x, int n) {

        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        double res = pow(x, n/2);
        res = res * res;
        if (n % 2 != 0)
            res *= x;
        return res;
    }
}
