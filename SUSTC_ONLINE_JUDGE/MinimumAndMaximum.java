import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAndMaximum {
    static InputReader in;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] array = new int[n];
            for (int a = 0; a < n; a++) {
                array[a] = in.nextInt();
            }
            System.out.print(getAnswer(array, n, k));
        }
    }

    private static StringBuilder getAnswer(int[] array, int n, int k) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        int[] minResult = new int[n - k + 1];
        int[] maxResult = new int[n - k + 1];
        int i = 0;
        while (i < n) {
            boolean minFlag = false;
            boolean maxFlag = false;
            boolean iIsBigger = false;
            if (i >= k)
                iIsBigger = true;
            if (i == k) {
                minResult[0] = array[minQueue.peekFirst()];
                maxResult[0] = array[maxQueue.peekLast()];
            }
            while (!minQueue.isEmpty()) {
                if (iIsBigger && i - minQueue.peekFirst() == k) {
                    minQueue.pollFirst();
                }
                if (array[i] <= array[minQueue.peekLast()]) {
                    minQueue.pollLast();
                } else {
                    minQueue.addLast(i);
                    if (iIsBigger)
                        minResult[i - k + 1] = array[minQueue.peekFirst()];
                    minFlag = true;
                    break;
                }
            }
            if (!minFlag) {
                minQueue.addLast(i);
                if (iIsBigger) minResult[i - k + 1] = array[minQueue.peekFirst()];
            }
            while (!maxQueue.isEmpty()) {
                if (iIsBigger && i - maxQueue.peekLast() == k) {
                    maxQueue.pollLast();
                }
                if (array[i] >= array[maxQueue.peekFirst()]) {
                    maxQueue.pollFirst();
                } else if (array[i] < array[maxQueue.peekFirst()]) {
                    maxQueue.addFirst(i);
                    if (iIsBigger)
                        maxResult[i - k + 1] = array[maxQueue.peekLast()];
                    maxFlag = true;
                    break;
                }
            }
            if (!maxFlag) {
                maxQueue.addFirst(i);
                if (iIsBigger) maxResult[i - k + 1] = array[maxQueue.peekLast()];
            }
            i++;
        }

        return getResult(minResult).append("\n").append(getResult(maxResult)).append("\n");
    }

    private static StringBuilder getResult(int[] result) {
        StringBuilder builder = new StringBuilder();
        for (int aResult : result) {
            builder.append(aResult).append(" ");
        }
        return builder.deleteCharAt(builder.length() - 1);
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