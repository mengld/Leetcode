class Solution {

    private BinarySearch() {}

    public int search(int[] data, int target) {

        int l = 0, r = data.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0)
                return mid;
            else if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }
}
