class Solution {
    public int minArray(int[] numbers) {

        if (numbers == null || numbers.length == 0)
            return -1;

        if (numbers.length == 1)
            return numbers[0];

        int pre = numbers[0];
        for (int i = 1; i < numbers.length; i ++) {
            if (numbers[i] < pre)
                return numbers[i];
            pre = numbers[i];
        }

        return numbers[0];
    }
}
