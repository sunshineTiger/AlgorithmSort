package OneTest;

public class test {

    public static void main(String[] args) {
//        MergeSort mergeSort = new MergeSort();
        int a[] = {64, 12, 41, 99, 85, 67, 21, 2, 4, 5, 8, 52, 9};
        //        mergeSort.Merge(a, 0, 4, a.length - 1);
//        InsetSort insetSort = new InsetSort();
//        insetSort.Sort(a);
        ChoseSort sort = new ChoseSort();
        sort.sort(a);
        for (
                int i = 0;
                i < a.length; i++) {
            System.out.print(a[i] + ",");
        }

    }


}
