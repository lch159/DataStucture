package LAB5;

import java.util.*;

public class Cycle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder("");
        int T = input.nextInt();
        String err;
        for (int i = 0; i < T; i++) {
            int pl = input.nextInt();
            err = input.next();
            char[] pattern = err.toCharArray();
            int[] next = getNext(pattern, pl);
            int length = pl-next[pl];
            result.append(length).append("\n");
        }
        System.out.print(result);

    }

    private static int[] getNext(char[] p, int pl) {
        int[] next = new int[pl + 1];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pl) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else k = next[k];
        }
        return next;
    }
}
