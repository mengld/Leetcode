/// Source : https://leetcode-cn.com/problems/two-sum/
/// Author : mengld
/// Time   : 2020-2-13
//  暴力枚举

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
