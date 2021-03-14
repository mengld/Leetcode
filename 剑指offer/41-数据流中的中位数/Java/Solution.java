import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> left = null;
    private PriorityQueue<Integer> right = null;
    private int N = 0;

    /** initialize your data structure here. */
    public MedianFinder() {

        left = new PriorityQueue<>((o1, o2) -> o2-o1);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // 定义N为偶数的情况下，加入最小堆。因为要满足最大堆所有元素均小于最大堆所有元素，因此，先将新加入元素加入到最大堆，选出其中最大元素再加入最小堆
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        }
        else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public double findMedian() {

        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        }
        else
            return (double)right.peek();
    }
}
