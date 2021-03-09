class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] cnt = new int[nums.length];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] == 2)
                return num;
        }
        
        return -1;
    }
}
