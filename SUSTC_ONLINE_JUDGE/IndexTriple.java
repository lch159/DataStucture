package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class IndexTriple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++)
                a[j] = input.nextInt();

            HashSet<Vector<Integer>> set = new HashSet<>();
            for (int p = 0; p < a.length; p++) {
                int b = a[p];
                int j = p + 1;
                int k = a.length - 1;
                while (j < k) {
                    int sum = b + a[j] + a[k];
                    if (sum < m) {
                        j++;
                    } else if (sum > m) {
                        k--;
                    } else {
                        Vector<Integer> vector = new Vector<>(3);
                        vector.add(b);
                        vector.add(a[j]);
                        vector.add(a[k]);
                        set.add(vector);
                        j++;
                        k--;
                    }
                }
            }
            if (set.isEmpty())
                System.out.println("NO");
            else System.out.println("YES");
        }

    }

}
