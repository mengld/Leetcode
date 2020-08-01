// https://leetcode-cn.com/problems/maximum-subarray/submissions/
// mengld
// 2020-2-13
// 贪心算法

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            throw new IllegalArgumentException("nums is null");

        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
