import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode502 {
    // 502. IPO
    // public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    //     int n = profits.length;
    //     int[][] pairs = new int[n][2];
    //     for(int i = 0; i < n; i++) {
    //         pairs[i][0] = capital[i];
    //         pairs[i][1] = profits[i];
    //     }

    //     Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
    //     int i = 0;
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(n, (a, b) -> b - a);
    //     while(k > 0) {
    //         while(i < n && pairs[i][0] <= w) {
    //             pq.offer(pairs[i][1]);
    //             i++;
    //         }
    //         if(pq.isEmpty()) {
    //             break;
    //         }
    //         w += pq.poll();
    //         k--;
    //     }
    //     return w;
    // }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = capital[i];
            pairs[i][1] = profits[i];
        }

        mergeSort(pairs, 0, n - 1);

        int i = 0;
        BinaryHeapMaxHeap heap = new BinaryHeapMaxHeap(n);
        while (k > 0) {
            while (i < n && pairs[i][0] <= w) {
                heap.offer(pairs[i][1]);
                i++;
            }
            if (heap.isEmpty()) {
                break;
            }
            w += heap.poll();
            k--;
        }
        return w;
    }

    // Custom merge sort
    private void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[][] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] leftArr = new int[n1][2];
        int[][] rightArr = new int[n2][2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i].clone();
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j].clone();
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i][0] <= rightArr[j][0]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}

class BinaryHeapMaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public BinaryHeapMaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return root;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
