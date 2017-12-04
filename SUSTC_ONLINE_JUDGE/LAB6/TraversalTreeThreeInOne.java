package LAB6;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

///**
// * Created by 11611423 李晨昊 on 2017/11/24.1:17
// */
//public class TraversalTreeThreeInOne {
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
//            int root = tree.getRoot();
//
//
//            int preOrder_root=root;
//            Stack<Integer> preOrder = new Stack<>();
//            preOrder.push(preOrder_root);
//            while (!preOrder.isEmpty()) {
//                int current = preOrder.pop();
//                result.append(current).append(" ");
//                if (tree.isParent(current)) {
//                    if (tree.getChildNum(current) == 1)
//                        preOrder.push(tree.getLeft(current));
//                    if (tree.getChildNum(current) == 2) {
//                        preOrder.push(tree.getRight(current));
//                        preOrder.push(tree.getLeft(current));
//                    }
//                }
//            }
//            result.append("\n");
//
//            int inOrder_root= root;
//            Stack<Integer> inOrder = new Stack<>();
//            while (inOrder_root != 0 || !inOrder.isEmpty()) {
//                while (inOrder_root != 0) {
//                    inOrder.push(inOrder_root);
//                    inOrder_root = tree.getLeft(inOrder_root);
//                }
//                inOrder_root = inOrder.pop();
//                result.append(inOrder_root).append(" ");
//                inOrder_root = tree.getRight(inOrder_root);
//            }
//            result.append("\n");
//
//
//            int postOrder_root=root;
//            Stack<Integer> postOrder =new Stack<>();
//            Stack<Integer> postOrder2 =new Stack<>();
//            Integer p = 1;
//            while (postOrder_root!=0||!postOrder.empty()){
//                while (postOrder_root!=0){
//                    postOrder.push(postOrder_root);
//                    postOrder2.push(0);
//                    postOrder_root=tree.getLeft(postOrder_root);
//                }
//                while (!postOrder.empty()&&postOrder2.peek().equals(p)){
//                    postOrder2.pop();
//                    result.append(postOrder.pop()).append(" ");
//                }
//                if (!postOrder.empty()){
//                    postOrder2.pop();
//                    postOrder2.push(1);
//                    postOrder_root=postOrder.peek();
//                    postOrder_root=tree.getRight(postOrder_root);
//                }
//            }
//            result.append("\n");
//
//        }
//        out.print(result);
//        out.close();
//    }
//
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
//
//class BinaryTree {
//    private Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
//    private LinkedList<Integer> parentList = new LinkedList<>();
//    private LinkedList<Integer> childList = new LinkedList<>();
//
//    private int root;
//
//    public int getLeft(int key) {
//        return parentList.contains(key) ? map.get(key).get(0) : 0;
//    }
//
//    public int getRight(int key) {
//
//        return parentList.contains(key)&&getChildNum(key)==2 ? map.get(key).get(1) : 0;
//    }
//
//    public int getChildNum(int key) {
//        return map.get(key).size();
//    }
//
//    public boolean isParent(int key) {
//        return map.containsKey(key);
//    }
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