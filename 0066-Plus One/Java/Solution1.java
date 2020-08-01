// https://leetcode-cn.com/problems/plus-one/submissions/
// mengld
// 2020-2-14

class Solution {
    public int[] plusOne(int[] digits) {
        int i;
        for (i = digits.length - 1; i >= 0; i --) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
