package OneTest;

public class InsetSort {

    private void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void Sort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                //向前插入
                for (int j = i + 1; j > 0; j--) {
                    if (arr[j] < arr[j - 1])
                        swap(arr, j - 1, j);
                }
            } else {
                //向后插入
//                swap(arr, arr[i], arr[i + 1]);

            }


        }
    }

}
