class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length == 0 || k <= 0 || k > arr.length)
            return new int[0];
        if (arr.length == k)
            return arr;

        int[] res = new int[k];
        findMinKNum(arr, k - 1);
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void findMinKNum(int[] arr, int k) {

        int l = 0, h = arr.length - 1;
        while (h > l) {
            int j = partition(arr, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] arr, int l, int h) {

        int p = arr[l];
        int i = l, j = h + 1;
        while (true) {
            while (i < h && arr[++i] < p);
            while (j > l && arr[--j] > p);
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
