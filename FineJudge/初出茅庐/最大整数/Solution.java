/*
设有n个正整数（n≤30000），将它们联接成一排，组成一个最大的多位整数。 例如：n=3时，3个整数13，312，343联接成的最大整数为：34331213。 又如：n=4时，4个整数7，13，4，246联接成的最大整数为：7424613。
输入格式: 3 13 312 343
输出格式: 34331213
数据范围与提示: 整数的值都在1到100000之间。
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * @author mengld
 * @create 2021-07-11 15:03
 */
public class Solution2 {

    public static String getMaxNum(String[] nums) {
        int n = nums.length;

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            stringBuilder.append(nums[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.readLine();
        }

        System.out.print(getMaxNum(nums));
    }
}
