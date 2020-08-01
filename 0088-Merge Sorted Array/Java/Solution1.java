// https://leetcode-cn.com/problems/merge-sorted-array/submissions/
// mengld
// 2020-2-14


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newnum = new int[m + n];
        int i = 0, j = 0, t = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                newnum[t ++] = nums1[i ++];
            }
            else
                newnum[t ++] = nums2[j ++];
        }
        while (i < m) {
            newnum[t ++] = nums1[i ++];
        }
        while (j < n) {
            newnum[t ++] = nums2[j ++];
        }

        for (i = 0; i < m + n; i ++) {
            nums1[i] = newnum[i];
        }
    }

}
