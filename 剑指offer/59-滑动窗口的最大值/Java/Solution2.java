class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return new int[0];

        int[] res = new int[nums.length -  k + 1];
        int t = 0;
        for (int i = 0; i < res.length; i ++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j ++) {
                if (nums[j] > max)
                    max = nums[j];
            }
            res[t++] = max;
        }

        return res;
    }
}
