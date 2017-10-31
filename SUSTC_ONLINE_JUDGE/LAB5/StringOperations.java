package LAB5;

import java.util.Scanner;


public class StringOperations {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            StringBuilder n = new StringBuilder(input.next());
            int m = input.nextInt();
            StringBuilder result = new StringBuilder("");
            input.nextLine();
            for (int j = 0; j < m; j++) {
                String[] op= input.nextLine().split(" ");
                switch (op[0].charAt(0)) {
                    case 'A':
                        n.insert(Integer.parseInt(op[2]), op[1]);
                        result.append(n).append("\n");
                        break;
                    case 'D':
                        n.deleteCharAt(Integer.parseInt(op[1]));
                        result.append(n).append("\n");
                        break;
                    case 'S':
                        result.append(n.substring(Integer.parseInt(op[1]), Integer.parseInt(op[2])+1)).append("\n");
                        break;
                    case 'R':

                        result.append(n.reverse().substring(Integer.parseInt(op[1]), Integer.parseInt(op[2]) + 1)).append("\n");
                        break;
                }
            }
            System.out.print(result);
        }
    }
}

