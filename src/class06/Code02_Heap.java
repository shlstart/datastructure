package class06;

/**
 * Author: shlstart
 * Create: 2022-09-05
 */
public class Code02_Heap {
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }
        private void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }

        }
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private void heapify(int[] arr, int index, int heapSize) {
            //compare with left and right children
            //if have left child, then it might have right child
            int left = index * 2 + 1;
            while (left < heapSize) {
                //find largest of left and right
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1: left;
                largest =  arr[largest] > arr[index]? largest: index;
                if (largest == index) break;
                swap(arr, index, largest);
                index = largest;
                left = index * 2 + 1;
            }
        }
    }
}