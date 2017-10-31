package LAB1;

import java.util.Scanner;

public class CountPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            int a=Math.abs(x1-x2);
            int b=Math.abs(y1-y2);

            if (a==0&&b==0)
                System.out.println("1");
            else
                System.out.println(gcd(a,b)-1);
        }
    }

    private static int gcd(int a, int b)
    {
        return b== 0 ? a : gcd(b,a%b);
    }

}
/**************************************************************
 Problem: 1017
 User: 11611423
 Language: Java
 Result: 正确
 Time:212 ms
 Memory:11152 kb
 ****************************************************************/