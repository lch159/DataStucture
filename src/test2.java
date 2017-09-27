import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 李晨昊 on 2017/9/26.
 */
public class test2 {

    private static ArrayList<Integer> tmpArr = new ArrayList<>();
    private static int k;
    private static boolean flag;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            flag = false;
            int n = input.nextInt();
            k = input.nextInt();
            int[] com = new int[n];
            for (int j = 0; j < n; j++)
                com[j] = input.nextInt();

            if (k > com.length || com.length <= 0) {
                return;
            }
            combine(0, k, com);
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void combine(int index, int k, int[] arr) {
        if (k == 1) {
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                int sum = 0;
                for (Integer aTmpArr : tmpArr)
                    sum += aTmpArr;

                if (sum == test2.k) {
                    flag = true;
                }
                tmpArr.remove((Object) arr[i]);
            }
        } else if (k > 1) {
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]);
                combine(i + 1, k - 1, arr);
                tmpArr.remove((Object) arr[i]);
            }
        }
    }
}
