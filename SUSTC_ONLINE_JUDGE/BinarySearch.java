import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {

                array[j] = input.nextInt();
            }

            if (search(array, m))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean search(int[] array, int m) {
        boolean flag = false;
        int low = 0;
        int high = array.length - 1;
        while ((low <= high) && (low <= array.length - 1) && (high <= array.length - 1)) {
            int middle = (high + low) / 2;
            if (m == array[middle]) {
                flag = true;
                break;
            } else if (m < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return flag;
    }
}
