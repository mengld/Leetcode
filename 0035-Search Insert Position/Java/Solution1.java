// https://leetcode-cn.com/problems/search-insert-position/submissions/
// mengld
// 2020-2-13

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i ++) {
            if (target <= nums[i])
                return i;
        }
        return i;
    }
}
