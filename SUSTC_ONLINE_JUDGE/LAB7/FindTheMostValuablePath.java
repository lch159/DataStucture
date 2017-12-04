package LAB7;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class FindTheMostValuablePath {

    static class BinaryTreeNode {
        private long key;
        private long pathValue;
        private LinkedList<BinaryTreeNode> childs = new LinkedList<>();
        private BinaryTreeNode parent = null;

        public BinaryTreeNode(int value) {
            this.key = value;
        }

        public void setParent(BinaryTreeNode parent) {
            this.parent = parent;
        }

        public void setKey(long key) {
            this.key = key;
            this.pathValue = key;
        }

        public void addChild(BinaryTreeNode child) {
            this.childs.add(child);
        }

        public void setPathValue(long key) {
            this.pathValue = key;
        }

        public long getKey() {
            return this.key;
        }

        public BinaryTreeNode getParent() {
            return this.parent;
        }

        public long getPathValue() {
            return this.pathValue;
        }

        public LinkedList<BinaryTreeNode> getChilds() {
            return this.childs;
        }

        public boolean isLeaf() {
            return childs.size() == 0;
        }
    }

    static class BinaryTree {
        private ArrayList<BinaryTreeNode> tree = new ArrayList<>();
        private BinaryTreeNode root = null;
        private int size;
        private int index;
        private long maxPathValue;


        public BinaryTree(int size) {
            this.size = size;
            this.index = 0;
            this.maxPathValue = 0;
            for (int i = 0; i < size; i++) {
                tree.add(i, new BinaryTreeNode(i + 1));
            }
        }

        public void addNodeKey(long key) {
            tree.get(this.index++).setKey(key);
        }

        public void addNodes(int x, int y) {
            tree.get(x - 1).addChild(tree.get(y - 1));
            tree.get(y - 1).setParent(tree.get(x - 1));
        }

        public BinaryTreeNode getRoot() {
            for (BinaryTreeNode elem : tree) {
                if (elem.getParent() == null)
                    this.root = elem;
            }
            return this.root;
        }

        public void levelIterator(BinaryTreeNode root) {
            if (root == null) {
                return;
            }
            LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
            BinaryTreeNode current;
            queue.offer(root);//将根节点入队
            while (!queue.isEmpty()) {
                current = queue.poll();//出队队头元素并访问
                if (current.getParent() != null) {
                    current.setPathValue(current.getPathValue() + current.getParent().getPathValue());
                }
                if (current.isLeaf() && current.getPathValue() > this.maxPathValue) {
                    this.maxPathValue = current.getPathValue();
                }
                else {
                    for (BinaryTreeNode child : current.getChilds()) {
                        queue.offer(child);
                    }
                }
            }
        }

        public long getMaxPathValue() {
            return this.maxPathValue;
        }

    }

    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        int T = in.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = in.nextInt();

            BinaryTree tree = new BinaryTree(num);
            for (int j = 0; j < num; j++) {
                tree.addNodeKey(in.nextInt());
            }

            for (int j = 0; j < num - 1; j++) {
                tree.addNodes(in.nextInt(), in.nextInt());
            }

            tree.levelIterator(tree.getRoot());
            result.append(tree.getMaxPathValue()).append("\n");

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
