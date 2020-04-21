package towtest;

import java.util.Hashtable;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RBTree<Integer, Object> rbt = new RBTree<>();
        while (true) {

            System.out.println("输入：");
            String key = scanner.next();
            System.out.println();
//        rbt.insert(55, 55);
//        TreeOperation.show(rbt.getRoot());
//        rbt.insert(25 , 25);
//        TreeOperation.show(rbt.getRoot());
//        rbt.insert(75, 75);
//        TreeOperation.show(rbt.getRoot());
//        rbt.insert(15, 15);
//        TreeOperation.show(rbt.getRoot());
//        rbt.insert(48, 48);
//        rbt.insert(10, 10);
//        rbt.insert(100, 100);
            rbt.insert(Integer.valueOf(key), key);
            TreeOperation.show(rbt.getRoot());

        }
    }
}
