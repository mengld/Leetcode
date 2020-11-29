
class Solution {

    public class Array<E> {

        private E[] data;
        private int size;

        // 含参构造
        public Array(int capacity) {
            // error: data = new E[capacity];
            data = (E[])new Object[capacity];
            size = 0;
        }

        // 无参构造
        public Array() {
            this(10);
        }

        public Array(E[] arr) {
            data = (E[])new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        // 获取数组大小
        public int getSize() {
            return size;
        }

        // 获取数组容量
        public int getCapacity() {
            return data.length;
        }

        // 判空
        public boolean isEmpty() {
            return size == 0;
        }

        // 在数组尾部添加元素e
        public void addLast(E e) {
//        if (size < data.length)
//            data[size++] = e;
//        else
//            throw new IllegalArgumentException("AddLast failed. Array is full.");

            add(size, e);
        }

        // 在数组头部添加元素e
        public void addFirst(E e) {
            add(0, e);
        }

        // 在index索引处添加元素e
        public void add(int index, E e) {
//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed. Array is full.");

            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

            // 动态扩容
            if (size == data.length) {
                resize(2 * data.length);
            }

            for (int i = size - 1; i >= index; i --) {
                data[i + 1] = data[i];
            }

            data[index] = e;
            size++;
        }

        // 获取索引为index的值
        public E get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

        // 对索引为index的元素设置值为e
        public void set(int index, E e) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            data[index] = e;
        }

        // 查找数组中是否有元素e
        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i] == e)
                    return true;
            }
            return false;
        }

        // 查找数组中的元素e的索引，如果不存在元素e，则返回-1
        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i] == e)
                    return i;
            }
            return -1;
        }

        // 删除索引为index的元素
        public E remove(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");

            E ret = data[index];
            for (int i = index + 1; i < size; i ++)
                data[i - 1] = data[i];
            size --;
            data[size] = null;

            // 为防止复杂度震荡，当size达到capacity/4时，才将capacity减半
            if (size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);

            return ret;
        }

        // 删除首部元素
        public E removeFirst() {
            return remove(0);
        }

        // 删除尾部元素
        public E removeLast() {
            return remove(size - 1);
        }

        // 删除指定值的元素
        public void removeElement(E e) {
            int index = find(e);
            if (index != -1)
                remove(index);
        }

        public void swap(int i, int j) {
            if (i < 0 || i >= size || j < 0 || j >= size)
                throw new IllegalArgumentException("Index is illegal.");

            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i ++) {
                res.append(data[i]);
                if (i != size - 1)
                    res.append(", ");
            }
            res.append(']');

            return res.toString();
        }

        private void resize(int newCapacity) {
            E[] newData = (E[])new Object[newCapacity];
            for (int i = 0; i < size; i ++)
                newData[i] = data[i];
            data = newData;
        }
    }

    public class MaxHeap<E extends Comparable<E>> {

        private Array<E> data;

        public MaxHeap(int capacity) {
            data = new Array<>(capacity);
        }

        public MaxHeap() {
            data = new Array<>();
        }

        public MaxHeap(E[] arr) {

            data = new Array<>(arr);
            if (arr.length != 1)
                for (int i = parent(arr.length - 1); i >=0; i --)
                    siftDown(i);
        }

        public int size() {
            return data.getSize();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        private int parent(int index) {
            if (index == 0)
                throw new IllegalArgumentException("index-0 doesn't have parent.");

            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return index * 2 + 1;
        }

        private int rightChild(int index) {
            return index * 2 + 2;
        }

        public void add(E e) {

            data.addLast(e);
            siftUp(data.getSize() - 1);
        }

        private void siftUp(int k) {

            while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
                data.swap(k, parent(k));
                k = parent(k);
            }
        }

        public E findMax() {
            if (data.getSize() == 0)
                throw new IllegalArgumentException("Can not findMax when heap is empty.");
            return data.get(0);
        }

        public E extractMax() {

            E ret = findMax();

            data.swap(0, data.getSize() - 1);
            data.removeLast();
            siftDown(0);

            return ret;
        }

        private void siftDown(int k) {

            while (leftChild(k) < data.getSize()) {

                int j = leftChild(k);
                if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                    j++;

                if (data.get(k).compareTo(data.get(j)) >= 0)
                    break;

                data.swap(k, j);
                k = j;
            }
        }

        public E replace(E e) {

            E ret = findMax();

            data.set(0, e);
            siftDown(0);

            return ret;
        }
    }

    public interface Queue<E> {

        int getSize();
        boolean isEmpty();
        void enqueue(E e);
        E dequeue();
        E getFront();
    }

    public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

        private MaxHeap<E> maxHeap;

        public PriorityQueue() {
            maxHeap = new MaxHeap<>();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }
    }


    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i ++)
            pq.enqueue(arr[i]);

        for (int i = k; i < arr.length; i ++) {
            if (!pq.isEmpty() && arr[i] < pq.getFront()) {
                pq.dequeue();
                pq.enqueue(arr[i]);
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = pq.dequeue();
        }
        return res;
    }
}
