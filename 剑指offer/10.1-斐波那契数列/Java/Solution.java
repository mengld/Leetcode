class Solution {
    public int fib(int n) {

        if (n <= 1)
            return n;

        int[] nums = new int[n+1];
        nums[1] = 1;

        for (int i = 2; i <= n; i ++)
            nums[i] = (nums[i-1] + nums[i-2]) % 1000000007;

        return nums[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(48));
    }
}
