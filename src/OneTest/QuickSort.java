package OneTest;

public class QuickSort {
    public static void quickSort(int arr[], int l, int r) {
        if (l > r) {
            return;
        }
        int indexR = r;
        int indexL = l;
        int base = arr[l];
        while (indexL < indexR) {
            while (arr[indexR] >= base && indexL < indexR) {
                indexR--;
            }
            while (arr[indexL] <= base && indexL < indexR) {
                indexL++;
            }
            if (indexL < indexR) {
                int temp;
                temp = arr[indexR];
                arr[indexR] = arr[indexL];
                arr[indexL] = temp;
            }
        }
        arr[l] = arr[indexL];
        arr[indexL] = base;
        quickSort(arr, l, indexL - 1);
        quickSort(arr, indexL + 1, r);
    }
}
