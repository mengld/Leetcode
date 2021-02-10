import java.util.Arrays;

class Solution {
    public String minNumber(int[] nums) {

        if (nums == null || nums.length == 0)
            return null;

        int n = nums.length;
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = nums[i] + "";
        }
        Arrays.sort(numbers, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String number : numbers) {
            res.append(number);
        }
        return res.toString();
    }
}
