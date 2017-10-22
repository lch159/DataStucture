import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BeautifulNumber {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        task solver=new task();
        solver.solve(in,out);
        out.close();


    }


    public static class task{
        void solve(InputReader in, PrintWriter out){

            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                int nums[] = new int[n];
                for (int j = 0; j < n; j++) {

                    nums[j] = in.nextInt();

                }

                Queue<Integer> myQueue = new LinkedBlockingQueue<>(n);

                myQueue.offer(nums[0]);
                int k = 1;
                int complete = 0;
                while (k < n) {
                    if (myQueue.element() >= nums[k]) {
                        if (complete == 0)
                            myQueue.offer(nums[k]);
                        k++;
                    } else if (myQueue.element() < nums[k]) {
                        out.println(k + 1);
                        myQueue.poll();
                    }
                    if (myQueue.isEmpty()) {
                        myQueue.offer(nums[k]);
                        k++;
                    }
                    if (k == n) {
                        out.println(0);
                        myQueue.poll();
                        k = n - myQueue.size();
                        complete = 1;
                    }
                }
            }

        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
