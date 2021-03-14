import java.util.PriorityQueue;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int x = minHeap.peek();
            minHeap.poll();
            res[i] = x;
        }

        return res;
    }
}
