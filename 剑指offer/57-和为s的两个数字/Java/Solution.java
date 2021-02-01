class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null || nums.length < 2)
            return new int[0];
        int i = 0, j = nums.length - 1;
        int[] res = new int[2];

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                return res;
            }
            else if(nums[i] + nums[j] > target) {
                j --;
            }
            else {
                i ++;
            }
        }

        return new int[0];
    }
}
