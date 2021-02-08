class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return 0;

        int cnt = 0;
        for (int num : nums) {
            if (num == target)
                cnt++;
        }

        return cnt;
    }
}
