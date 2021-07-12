/*
文件内有大约100万个不重复的数字，这些数字的值都在[1, 10000000]之间，除此之外，最后一行为数字-1，表示结束，请对除-1以外的其他数字顺序排序。
输入格式：大约100万个数字的文件。
输出格式：排序后的文件。

样例
输入
10 6 11 9 5

输出
5 6 9 10 11
*/

import java.io.*;
import java.util.BitSet;

/**
 * @author mengld
 * @create 2021-07-11 20:55
 */
public class Solution5 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BitSet bitSet = new BitSet();
        String cur = reader.readLine();

        while (!"-1".equals(cur)) {
            bitSet.set(Integer.valueOf(cur));
            cur = reader.readLine();
        }

        String temp = bitSet.toString();
        temp = temp.substring(1, temp.length() - 1);
        temp = temp.replace(",", "");
        String[] s = temp.split(" ");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < s.length; i++) {
            out.println(s[i]);
        }
        out.flush();

    }
}
