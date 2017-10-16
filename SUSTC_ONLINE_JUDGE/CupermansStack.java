
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class CupermansStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            Queue<Integer> queue = new ArrayBlockingQueue<>(n);
            for (int j = 0; j < m; j++) {
                int operator = input.nextInt();

                switch (operator) {
                    case 1:
                        int value = input.nextInt();
                        if (queue.size() < n)
                            queue.add(value);
                        else
                            System.out.println(value);
                        break;
                    case 2:
                        if (!queue.isEmpty()) {
                            System.out.println(queue.poll());
                        }
                        break;
                }
            }
            while (!queue.isEmpty())
            {
                System.out.println(queue.poll());
            }
        }
    }
}
