package LAB6;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

//public class LevelTraversal {
//
//    public static void main(String[] args) throws IOException {
//        InputReader in = new InputReader(System.in);
//        PrintWriter out = new PrintWriter(System.out);
//
//        StringBuilder result = new StringBuilder();
//        final int T = in.nextInt();
//        for (int i = 0; i < T; i++) {
//            int num = in.nextInt();
//            BinaryTree tree = new BinaryTree();
//            for (int j = 0; j < num - 1; j++) {
//                tree.addNode(in.nextInt(), in.nextInt());
//            }
//
//            Queue<Integer> queue = new LinkedBlockingQueue<>();
//            queue.offer(tree.getRoot());
//            while (!queue.isEmpty()) {
//                int current = queue.poll();
//                result.append(current).append(" ");
//                if (tree.getParentList().contains(current) && tree.getMap().get(current).size() != 0) {
//                    for (int elem : tree.getMap().get(current)) {
//                        queue.offer(elem);
//                    }
//                }
//            }
//
//            result.append("\n");
//        }
//        out.print(result);
//        out.close();
//    }
//    static class InputReader {
//        BufferedReader br;
//
//        InputReader(InputStream stream) {
//            br = new BufferedReader(new InputStreamReader(stream));
//        }
//
//        public int nextInt() throws IOException {
//            int c = br.read();
//            while (c <= 32) {
//                c = br.read();
//            }
//            boolean negative = false;
//            if (c == '-') {
//                negative = true;
//                c = br.read();
//            }
//            int x = 0;
//            while (c > 32) {
//                x = x * 10 + c - '0';
//                c = br.read();
//            }
//            return negative ? -x : x;
//        }
//
//    }
//}

//class BinaryTree {
//    private Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
//    private LinkedList<Integer> parentList = new LinkedList<>();
//    private LinkedList<Integer> childList = new LinkedList<>();
//
//    private int root;
//
//    void addNode(int parentKey, int childKey) {
//        childList.add(childKey);
//        if (map.containsKey(parentKey)) {
//            map.get(parentKey).add(childKey);
//        } else {
//            parentList.add(parentKey);
//            LinkedList<Integer> childs = new LinkedList<>();
//            childs.add(childKey);
//            map.put(parentKey, childs);
//        }
//    }
//
//    LinkedList<Integer> getParentList() {
//        return this.parentList;
//    }
//
//    Map<Integer, LinkedList<Integer>> getMap() {
//        return this.map;
//    }
//
//    int getRoot() {
//        int root = 0;
//        for (int elem : parentList) {
//            if (!childList.contains(elem))
//                root = elem;
//        }
//        return root;
//    }
//}