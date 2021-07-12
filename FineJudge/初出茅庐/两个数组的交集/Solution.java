/*
求两个数组整数数组的交集。
输入格式: 输入格式为总共m+n+2行，第一行值为m，表示数组1的长度，接下来m行为数组1的元素，接下来的一行值为n，表示数组2的长度，再接下来的n行为数组2的元素。
5
1
1
3
5
7
4
4
6
8
9
输出格式: 数组输出为字符串后的md5编码：d751713988987e9331980363e24189ce
*/

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author mengld
 * @create 2021-07-11 16:57
 */
public class Solution {

    public static String getMD5(String result) {
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

    public static String bitset2IntArray(BitSet bitSet) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        String temp = bitSet.toString();
        builder.append(temp.substring(1, temp.length()-1));
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            bitSet1.set(scanner.nextInt());
        }

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            bitSet2.set(scanner.nextInt());
        }

        bitSet1.and(bitSet2);

        System.out.println(getMD5(bitset2IntArray(bitSet1)));
    }
}
