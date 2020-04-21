package OneTest;

public class MergeSort {

    public void Merge(int arr[], int l, int m, int r) {
        int leftSize = m;
        int rightSize = r - m + 1;
        int left[] = new int[leftSize];
        int right[] = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[i + m];
        }
        int indexl = 0, indexr = 0, key = 0;
        while (indexl < leftSize && indexr < rightSize) {
            if (left[indexl] < right[indexr]) {
                arr[key] = left[indexl];
                indexl++;
                key++;
                continue;
            }
            if (left[indexl] > right[indexr]) {
                arr[key] = right[indexr];
                indexr++;
                key++;
            }
        }
        if (indexl < leftSize) {
            for (int i = 0; i < leftSize - indexl; i++) {
                arr[key] = left[indexl];
            }
        }
        if (indexr < rightSize) {
            for (int i = 0; i < leftSize - indexl; i++) {
                arr[key] = left[indexl];
            }
        }
    }

}
