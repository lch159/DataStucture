package LAB3;

import java.util.LinkedList;
import java.util.Scanner;

public class CreateSpecialGroup {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                list.add(input.nextInt());
            }
            int m = input.nextInt();
            for (int j = 0; j < m; j++) {
                int operation = input.nextInt();
                switch (operation) {
                    case 1:
                        int position = input.nextInt();
                        int value = input.nextInt();
                        list.add(position, value);
                        break;
                    case 2:
                        int position2 = input.nextInt();
                        list.remove(position2);
                        break;
                    case 3:
                        int position3 = input.nextInt();
                        int value3 = input.nextInt();
                        list.set(position3, value3);
                        break;
                    case 4:
                        LinkedList<Integer> tempList = new LinkedList<>();

                        int index=0;
                        for (int p = list.size() - 1; p >= 0; p--) {
                            tempList.add(index,list.get(p));
                            index++;
                        }
                        list=tempList;
                        break;
                }

                    for (Integer elem : list)
                        System.out.print(elem + " ");
                    System.out.println();
            }
        }
    }
}
