class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length)
            return new int[0];

        int[] res = new int[nums.length - k + 1];
        int t = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < k; i ++)
            maxHeap.add(nums[i]);
        res[t++] = maxHeap.peek();

        for (int i = 0, j = i + k; j < nums.length; i ++, j ++) {

            maxHeap.remove(nums[i]);
            maxHeap.add(nums[j]);
            res[t++] = maxHeap.peek();
        }

        return res;
    }
}
