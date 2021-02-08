class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1 && nums[0] == target)
            return 1;

        int i = binarySearch(nums, target);
        int j = binarySearch(nums, target + 1);

        return (i == nums.length || nums[i] != target) ? 0 : j - i;

    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target)
                h = m;
            else
                l = m + 1;
        }

        return l;
    }
}
