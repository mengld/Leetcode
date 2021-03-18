import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] maxLen = new int[nums.length];
        Arrays.fill(maxLen, 1);

        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j])
                    maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
            }
        }

        int max = -1;
        for (int i = 0; i < maxLen.length; i ++) {
            if (max < maxLen[i])
                max = maxLen[i];
        }
        
        return max;
    }
}
