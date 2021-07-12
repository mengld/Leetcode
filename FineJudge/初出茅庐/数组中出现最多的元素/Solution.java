/*
给你一个数组，输出里面出现超过1/2的元素。保证有且只有一个解。
输入格式: 第一行是一个整数n(n <=1e7)，表示测试数据的个数 ，之后每一行都是一个整数。
输出格式: 输出出现超过1/2的那个数字。
样例: 
输入
5
1
1
1
2
3
输出
1
*/

import java.util.Scanner;

/**
 * @author mengld
 * @create 2021-07-11 14:51
 */
public class Solution {

    public static int FindMajorityNum(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (candidate == nums[i]) {
                count ++;
            }
            else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(FindMajorityNum(nums));
    }
}
