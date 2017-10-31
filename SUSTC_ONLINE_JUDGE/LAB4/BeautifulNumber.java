package LAB4;

import java.io.*;
import java.util.Stack;


public class BeautifulNumber {

    static InputReader in;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int nums[] = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            StringBuilder result = new StringBuilder();

            int[] arrayResult = FindRfmax(nums);
            for (int elem : arrayResult) {
                result.append(elem).append("\n");
            }
            System.out.print(result);
        }


    }

    private static int[] FindRfmax(int[] nums) {
        int len = nums.length;
        if (len == 0) return nums;
        int i = 0;
        int[] res = new int[len];
        Stack<Integer> stk = new Stack<>();
        while (i < len) {
            if (stk.empty() || nums[stk.peek()] >= nums[i]) {
                stk.push(i++);
            } else {
                res[stk.peek()] = i+1;
                stk.pop();
            }
        }
        while (!stk.empty()) {
            res[stk.peek()] = 0;
            stk.pop();
        }
        return res;
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