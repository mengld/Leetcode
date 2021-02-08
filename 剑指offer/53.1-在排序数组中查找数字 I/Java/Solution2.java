class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return 0;

        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                break;
        }
        i --;
        int j;
        for (j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target)
                break;
        }

        int cnt = j - i;
        return cnt > 0 ? cnt : 0;
    }
}
