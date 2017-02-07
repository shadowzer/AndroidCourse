package Default;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySystem {
    private static List<MySet> sets;

    public static void main(String[] args) {
        sets = new ArrayList<>();
        hardCodeFillingExample();

        System.out.println("Введите 1 для операции union, 2 для операции find, 0 для выхода из программы.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int p = 0, q = 0;
        while (choice != 0) {
            if (choice > 0 && choice < 3) {
                System.out.println("Введите 2 числа - номера множеств, к которым будет применена операция");
                p = sc.nextInt();
                q = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    union(p, q);
                    break;
                case 2:
                    System.out.println(find(p, q));
                    break;
                default:
                    System.out.println("Введите 1 для операции union, 2 для операции find, 0 для выхода из программы.");
                    break;
            }
            choice = sc.nextInt();
        }
    }

    private static boolean isIdCorrect(int ID) {
        if (!(ID >= 0 && ID < sets.size())) {
            System.out.println("There is no set with ID = " + ID);
            return false;
        }
        return true;
    }

    public static boolean union(int p, int q) {
        if (!isIdCorrect(p) || !isIdCorrect(q))
            return false;

        sets.get(p).addConnection(q);
        sets.get(q).addConnection(p);
        return true;
    }

    public static boolean find(int p, int q) {
        if (!isIdCorrect(p) || !isIdCorrect(q))
            return false;

        for(MySet item : sets) {
            if (item.getID() == p && item.isConnectionExists(q))
                return true;
            if (item.getID() == q && item.isConnectionExists(p))
                return true;
        }

        return false;
    }

    private static void hardCodeFillingExample() {
        sets.add(new MySet(0));
        sets.add(new MySet(1));
        sets.add(new MySet(2));
        sets.add(new MySet(3));
        sets.add(new MySet(4));
        sets.add(new MySet(5));
        sets.add(new MySet(6));
        sets.add(new MySet(7));

        union(1, 4);
        union(4, 5);
        union(2, 3);
        union(2, 6);
        union(3, 6);
        union(3, 7);
    }
}
