
import java.util.Scanner;

public class Main {

    private static int[][] obj;
    private static int objLineIndex;


    private static double cal(int num) {
        if (num == 1)
            return 1d;
        else {
            if(num >1){
                return num * cal(num-1);
            }
            return 1d;
        }
    }
}
    private static int combination(int m) {

        return (int)cal(m)/(cal(3)*cal(m- 3));
    }

    private static void combine(int a[], int srcIndex, int i, int n, int[] tmp) {
        int j;
        for (j = srcIndex; j < a.length - (n - 1); j++) {
            tmp[i] = a[j];
            if (n == 1) {

                System.arraycopy(tmp, 0, obj[objLineIndex], 0, tmp.length);
                objLineIndex++;

            } else {
                n--;
                i++;
                combine(a, j + 1, i, n, tmp);
                n++;
                i--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++)
                array[j] = input.nextInt();

            boolean flag = false;
            objLineIndex = 0;
            obj = new int[combination(array.length)][3];
            combine(array, 0, 0, 3, new int[3]);


            for (int[] p : obj) {
                int sum = 0;
                for (int q : p) {
                    sum += q;
                }
                if (sum == m)
                    flag = true;
            }


            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
