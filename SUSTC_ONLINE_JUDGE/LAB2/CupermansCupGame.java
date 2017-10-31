package LAB2;

import java.util.Scanner;

public class CupermansCupGame {
    private static int iniX;
    private static int iniY;
    private static int steps;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            iniX = x;
            iniY = y;
            steps = 0;
            int result = compare(x, y);
            if (result == -1)
                System.out.println(result);
            else
                System.out.println(result + 1);
        }
    }

    private static int compare(int x, int y) {
        while (x != y) {
            if (x == iniY && y == iniX) {
                steps = -1;
                break;
            } else if (x > y) {
                int temp = y;
                y += temp;
                x -= temp;
                steps++;
                compare(x, y);
                break;
            } else if (x < y) {
                int temp = x;
                x += temp;
                y -= temp;
                steps++;
                compare(x, y);
                break;
            }
        }
        return steps;
    }
}
