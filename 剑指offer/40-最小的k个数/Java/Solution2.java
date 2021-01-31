import java.util.PriorityQueue;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        if (k <= 0 || k > arr.length)
            return new int[0];
        if (k == arr.length)
            return arr;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while (!maxHeap.isEmpty())
            res[i ++] = maxHeap.poll();

        return res;
    }
}
