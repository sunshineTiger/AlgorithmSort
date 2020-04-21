package OneTest;

public class HeapSort {

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 重构堆
     *
     * @param arr
     * @param n
     * @param i
     */
    public void heapify(int arr[], int n, int i) {
        if (n <= i)
            return;
        int childLIndex = 2 * i + 1;
        int childRIndex = 2 * i + 2;
        int maxIndex = i;
        if (childLIndex < n && arr[maxIndex] < arr[childLIndex]) {
            maxIndex = childLIndex;
        }
        if (childRIndex < n && arr[maxIndex] < arr[childRIndex]) {
            maxIndex = childRIndex;
        }
        if (maxIndex != i) {
            swap(arr, i, maxIndex);
            heapify(arr, n, maxIndex);
        }
    }

    /**
     * 构建堆
     *
     * @param arr
     * @param n
     */
    private void build_heap(int[] arr, int n) {
        int node = n - 1;
        int parent = (node - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(arr, n, i);//数组，长度，第几个
        }
    }


    public void heapSort(int[] arr, int n) {
        /**
         * 完全二叉树
         * 父亲节点的值大于左右孩子节点的值
         * */
        build_heap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

}
