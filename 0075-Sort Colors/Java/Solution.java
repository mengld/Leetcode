import java.util.Random;

public class Solution {
    public void sortColors(int[] nums) {
        Random rnd = new Random();
        sort3ways(nums, 0, nums.length - 1, rnd);
    }

    private static <E> void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void sort3ways(int[] nums, int l, int r, Random rnd) {
        if (l >= r)
            return;

        // 生成[l, r]之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(nums, l, p);

        // arr[l+1, lt] < v; arr[lt+1, i - 1] == v; arr[gt, r] > v.
        int lt = l, i = l + 1, gt = r + 1;

        while (i < gt) {

            if (nums[i] < nums[l]) {
                lt ++;
                swap(nums, i, lt);
                i ++;
            }
            else if (nums[i] > nums[l]) {
                gt --;
                swap(nums, i, gt);
            }
            else {
                i ++;
            }
        }

        swap(nums, l, lt);
        // arr[l, lt-1] < v; arr[lt, gt - 1] == v; arr[gt, r] > v

        sort3ways(nums, l, lt - 1, rnd);
        sort3ways(nums, gt, r, rnd);
    }
}
