class Solution {
    public int minArray(int[] numbers) {

        if (numbers == null || numbers.length == 0)
            return -1;

        if (numbers.length == 1)
            return numbers[0];

        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (numbers[l] == numbers[m] && numbers[m] == numbers[h])
                return minArray(numbers, l, h);
            else if (numbers[m] <= numbers[h])
                h = m;
            else
                l = m + 1;
        }

        return numbers[l];
    }

    private int minArray(int[] numbers, int l, int h) {

        for (int i = l; i < h; i ++)
            if (numbers[i] > numbers[i + 1])
                return numbers[i + 1];

         return numbers[l];
    }
}
