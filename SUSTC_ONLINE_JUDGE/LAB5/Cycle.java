package LAB5;

import java.util.Scanner;

public class Cycle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder("");
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int tl = input.nextInt();
            String t=input.next();
            char[] text = t.toCharArray();

            long sum=0;
            for (int j = 0; j < tl; j++) {

                char[] pattern =t.substring(0, tl).toCharArray();
                long cnt= cnt(text,pattern,tl,j+1);
                sum=sum+(j+1)*cnt;

            }
            System.out.print(sum);
        }

    }

    private static long cnt(char[] text,char[] pattern,int tl,int pl){
        int[] next = getNext(pattern, pl);
        int ti = 0;
        int pi = 0;
        long sum = 0;
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
        return sum;
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

