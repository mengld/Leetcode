import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return new int[0];


        int[] res = new int[nums.length -  k + 1];
        int t = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if (i > k-2) {
                res[t++] = maxHeap.peek();
                maxHeap.remove(nums[i-k+1]);
            }
        }

        return res;
    }
}
