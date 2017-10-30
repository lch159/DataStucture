import java.util.Scanner;

/**
 * Created by 11611423 李晨昊 on 2017/10/23.23:13
 */
public class KateMakeProgram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder("");
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int tl = input.nextInt();
            char[] text = input.next().toCharArray();
            int pl = input.nextInt();
            char[] pattern = input.next().toCharArray();

            int[] next = getNext(pattern, pl);
            int ti = 0;
            int pi = 0;
            int sum = 0;
            int ini = 0;
            if (next[pl - 1] != 0) ini = next[pl - 1] + 1;
            while (ti < tl && pi < pl) {
                if (pi == -1 || text[ti] == pattern[pi]) {
                    if (pi == pl - 1 && text[ti] == pattern[pi]) {
                        sum++;
                        if (next[pl-1]!=0)
                            ti++;
                        pi = ini;
                    } else {
                        pi++;
                        ti++;
                    }
                } else pi = next[pi];
            }
            result.append(sum).append("\n");
        }
        System.out.print(result);
    }

    private static int[] getNext(char[] p, int pl) {
        int[] next = new int[pl];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pl - 1) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else k = next[k];
        }
        return next;
    }
}
