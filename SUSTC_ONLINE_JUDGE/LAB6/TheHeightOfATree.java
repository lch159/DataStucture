package LAB6;

import java.io.*;

public class TheHeightOfATree {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        StringBuilder result =new StringBuilder();
        final int T = in.nextInt();
        for (int i = 0; i < T; i++) {

            int n = in.nextInt();
            int sum=0;
            while (n >= 2) {
                n /=2;
                sum++;
            }
            result.append(sum).append("\n");
        }
        out.print(result);
        out.close();
    }

    static class InputReader {
        BufferedReader br;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public int nextInt() throws IOException {
            int c = br.read();
            while (c <= 32) {
                c = br.read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = br.read();
            }
            int x = 0;
            while (c > 32) {
                x = x * 10 + c - '0';
                c = br.read();
            }
            return negative ? -x : x;
        }

    }
}
