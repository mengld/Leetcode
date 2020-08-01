/// Source : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
/// Author : mengld
/// Time   : 2020-2-13
//  双指针法

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j])
                j ++;
            else {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
