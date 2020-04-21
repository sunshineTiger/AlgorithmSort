package OneTest;

public class TwoFind {
    public int TwofenSort(int[] arr, int val) {
        int mid = 0;
        int low = 0;
        int height = arr.length - 1;
        while (low < height) {
            mid = (low + height) / 2;
            if (val == arr[mid]) {
                return mid;
            } else if (val > arr[mid]) {
                low = mid + 1;
            } else {
                height = mid - 1;
            }
        }
        return mid;
    }
}
