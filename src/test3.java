
import java.util.Scanner;

public class test3 {

    private static int sum;
    private static boolean flag;
    private static int m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();

            m = input.nextInt();
            sum = 0;
            flag = false;

            int[] array = new int[n];
            for (int j = 0; j < n; j++)
                array[j] = input.nextInt();

            Integer[] a = toIntegerArray(array);
            combinationSelect(a, 3);

            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }


    private static Integer[] toIntegerArray(int[] arr) {
        int n = arr.length;
        Integer[] iarr = new Integer[n];
        for (int i = 0; i < n; i++) {
            iarr[i] = arr[i];
        }
        return iarr;
    }

    private static void combinationSelect(Integer[] dataList, int n) {
        combinationSelect(dataList, 0, new Integer[n], 0);
    }

    private static void combinationSelect(Integer[] dataList, int dataIndex, Integer[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            sum = 0;
            for (Integer aResultList : resultList) {
                sum += aResultList;
            }

            if (sum == m)
                flag = true;
            return;
        }

        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }
}