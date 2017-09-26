import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int x = input.nextInt();
            long[][] a = new long[3][n];
            for (int j = 0; j < n; j++)
                a[0][j] = input.nextInt();


            int p = k / n;
            int r = k % n;

            for (int j = 0; j < n; j++)
                a[1][j] = p;

            while (r > 0) {
                a[1][x]++;
                x++;
                if (x == n)
                    x = 0;
                r--;
            }

            for (int j = 0; j < n; j++) {
                a[2][j] = power(a[0][j], a[1][j], 123456789);
                if (j != n - 1)
                    System.out.print(a[2][j] + " ");
                else {
                    System.out.println(a[2][j]);
                }
            }
        }
    }

    private static long power(long x, long n, long p) {
        if (n == 0)
            return 1;
        long tmp = power((x * x) % p, n / 2, p);
        if (n % 2 != 0)
            tmp = (tmp * x) % p;

        return tmp;
    }
}
