class Solution {
    public int[] exchange(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0)
                i ++;
            while (i < j && nums[j] % 2 == 0)
                j --;
            swap(nums, i, j);
        }

        return nums;
    }

    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
