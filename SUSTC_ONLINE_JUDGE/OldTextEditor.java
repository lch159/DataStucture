import java.util.LinkedList;
import java.util.Scanner;

public class OldTextEditor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            String s = input.next();
            StringBuilder stringBuffer =new StringBuilder(s);
            int n = input.nextInt();

            for (int j = 0; j < n; j++) {
                int operation = input.nextInt();
                switch (operation) {
                    case 1:
                        char value = input.next().charAt(0);
                        int position = input.nextInt() - 1;
                        stringBuffer.insert(position, value);
                        break;
                    case 2:
                        int position2 = input.nextInt() - 1;
                        System.out.println(stringBuffer.charAt(position2));
                        break;
                }
            }
        }
    }
}
