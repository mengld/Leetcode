/*
给定两个有序整数数组 num1 和 num2，将两个有序数组合并。
数组读取方式
Scanner scanner = new Scanner(System.in);
int m = scanner.nextInt();
int[] num1 = new int[m];
for (int i = 0; i < m; i++) {
    num1[i] = scanner.nextInt();
}
int n = scanner.nextInt();
int[] num2 = new int[n];
for (int i = 0; i < n; i++) {
    num2[i] = scanner.nextInt();
}
输入格式: 输入格式为m+n+2行，第一行值为m，表示数组1的长度，接下来m行为数组1的元素，接下来的一行值为n，表示数组2的长度，再接下来的n行为数组2的元素。
5
49114
55605
56857
64703
99863
4
712001
1341177
2320326
7627675
输出格式: 数组输出为字符串后的md5编码：cd571095bb59f5c0c0fbb4532e756ac8 注意：数字转为字符串并生成md5编码时，要转成[123, 345, 789]这样格式的字符串。
*/

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mengld
 * @create 2021-07-11 21:12
 */
public class Solution4 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static String getMD5(int[] num) {
        String result = Arrays.toString(num);
        String s = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(result.getBytes());
            byte[] digest = md5.digest();
            s = new BigInteger(1, digest).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] num1 = new int[m];
        for (int i = 0; i < m; i++) {
            num1[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num2[i] = scanner.nextInt();
        }

        int[] temp = new int[num1.length + num2.length];
        System.arraycopy(num1, 0, temp, 0, num1.length);
        num1 = temp;

        merge(num1, m, num2, n);
        System.out.println(getMD5(num1));
    }
}
