import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        Arrays.sort(arr);
        int[] res = Arrays.copyOf(arr, k);
        return res;
    }
}
