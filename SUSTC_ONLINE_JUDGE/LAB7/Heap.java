package LAB7;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 11611423 李晨昊 on 2017/12/4.21:31
 */
public class Heap {
    private static InputReader in;
    private static PrintWriter out;

    static class BinaryHeap {
        ArrayList<Integer> heap = new ArrayList<>();


        public BinaryHeap() {
            heap.add(0);
        }

        public void insertNode(int value) {
            int index = heap.size();
            heap.add(value);
            if (heap.size() != 2) {
                while (heap.get(index) < heap.get(index / 2)) {
                    int temp = heap.get(index);
                    heap.set(index, heap.get(index / 2));
                    heap.set(index / 2, temp);
                    index = index / 2;
                }
            }
        }

        public Integer getRoot() {
            return heap.get(0);
        }

        public void deleteMin() {
            heap.set(1, heap.remove(heap.size() - 1));
            int index = 1;

            while (index * 2 < heap.size() - 1) {

                int smaller, bigger;
                if (heap.get(index * 2 + 1) >= heap.get(index * 2)) {
                    smaller = index * 2;
                    bigger = index * 2 + 1;
                } else {
                    smaller = index * 2 + 1;
                    bigger = index * 2;
                }
                if (heap.get(index) > heap.get(smaller)) {
                    int temp = heap.get(index);
                    heap.set(index, heap.get(smaller));
                    heap.set(smaller, temp);
                    index = smaller;
                } else if (heap.get(index) > heap.get(bigger)) {
                    int temp = heap.get(index);
                    heap.set(index, heap.get(bigger));
                    heap.set(bigger, temp);
                    index = bigger;
                }
            }
            if (index * 2 == heap.size() - 1) {
                if (heap.get(index) > heap.get(index * 2)) {
                    int temp = heap.get(index);
                    heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp);
                }
            }
        }

        public int queryMin() {
            return heap.get(1);
        }
    }

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        int T = in.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = in.nextInt();

            BinaryHeap heap = new BinaryHeap();
            for (int j = 0; j < num; j++) {
                heap.insertNode(in.nextInt());
            }

            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                switch (in.nextInt()) {
                    case 1:
                        heap.insertNode(in.nextInt());
                        break;
                    case 2:
                        heap.deleteMin();
                        break;
                    case 3:
                        result.append(heap.queryMin()).append("\n");
                        break;
                }
            }
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
