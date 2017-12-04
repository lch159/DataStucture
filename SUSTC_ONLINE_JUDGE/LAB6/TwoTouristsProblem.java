package LAB6;

import java.io.*;
import java.util.*;

/**
 * Created by 11611423 李晨昊 on 2017/11/25.17:51
 */
class BinaryTreeNode {
    private int key;
    private BinaryTreeNode parent = null;
    private BinaryTreeNode left = null;
    private BinaryTreeNode right = null;
    private int maxLeftLen;
    private int maxRightLen;
    private int longstpath = 0;
    private int depth = 0;


    public BinaryTreeNode(int value) {
        this.key = value;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void setLongstpath(int value) {
        this.longstpath = value;
    }

    public int getKey() {
        return this.key;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }

    public BinaryTreeNode getParent() {
        return this.parent;
    }

    public int getLongstpath() {
        return this.longstpath;
    }

    public int getDepth() {
        return this.depth;
    }

    public boolean isLeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }

    public boolean isFull() {
        return this.getRight() != null && this.getLeft() != null;
    }

    public void removeChild() {
        this.setLeft(null);
        this.setRight(null);
    }

    public int getMaxLeftLen() {
        return maxLeftLen;
    }

    public void setMaxLeftLen(int maxLeftLen) {
        this.maxLeftLen = maxLeftLen;
    }

    public int getMaxRightLen() {
        return maxRightLen;
    }

    public void setMaxRightLen(int maxRightLen) {
        this.maxRightLen = maxRightLen;
    }

}

class BinaryTree {
    private LinkedList<BinaryTreeNode> tree = new LinkedList<>();
    private BinaryTreeNode root = null;

    private int maxLen = 0;

    public BinaryTree(int size) {
        for (int i = 0; i < size; i++) {
            tree.add(i, new BinaryTreeNode(i + 1));
        }
    }

    public void addNodes(int x, int y) {
        if (tree.get(x - 1).getLeft() != null) {
            tree.get(x - 1).setRight(tree.get(y - 1));
        } else {
            tree.get(x - 1).setLeft(tree.get(y - 1));
        }
        tree.get(y - 1).setParent(tree.get(x - 1));
    }

    public BinaryTreeNode getRoot() {
        for (BinaryTreeNode elem : tree) {
            if (elem.getParent() == null)
                root = elem;
        }
        return root;
    }

    int getTreeDepth(BinaryTreeNode T)//计算二叉树的深度，递归法
    {
        if (T == null)
            return 0;
        int Dleft = getTreeDepth(T.getLeft());
        int Dright = getTreeDepth(T.getRight());
        return (Dleft > Dright) ? (Dleft + 1) : (Dright + 1);
    }


    int getMaxDistance(BinaryTreeNode T)//计算二叉树结点的最大距离，递归法
    {
        if (T == null)
            return 0;
        int Distance = getTreeDepth(T.getLeft()) + getTreeDepth(T.getRight());
        int l_Distance = getMaxDistance(T.getLeft());
        int r_Distance = getMaxDistance(T.getRight());
        Distance = (Distance > r_Distance) ? Distance : r_Distance;
        Distance = (Distance > l_Distance) ? Distance : l_Distance;
        return Distance;
    }

    public void findMaxLen(BinaryTreeNode root) {

        if (root == null) return;

        if (root.getLeft() == null) root.setMaxLeftLen(0);

        if (root.getRight() == null) root.setMaxRightLen(0);

        if (root.getLeft() != null) findMaxLen(root.getLeft());

        if (root.getRight() != null) findMaxLen(root.getRight());

        if (root.getLeft() != null) {
            int temp = 0;
            BinaryTreeNode left = root.getLeft();
            temp = left.getMaxLeftLen() > left.getMaxRightLen() ? left.getMaxLeftLen() : left.getMaxRightLen();
            root.setMaxLeftLen(temp + 1);
        }
        if (root.getRight() != null) {
            int temp = 0;
            BinaryTreeNode right = root.getRight();
            temp = right.getMaxLeftLen() > right.getMaxRightLen() ? right.getMaxLeftLen() : right.getMaxRightLen();
            root.setMaxRightLen(temp + 1);
        }
        if (maxLen < root.getMaxLeftLen() + root.getMaxRightLen()) {
            maxLen = root.getMaxLeftLen() + root.getMaxRightLen();
        }
    }

    public int getMaxLen() {
        findMaxLen(this.getRoot());
        return maxLen;
    }

}


public class TwoTouristsProblem {
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
            for (int j = 0; j < num - 1; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                tree.addNodes(x, y);
            }

            BinaryTreeNode root =tree.getRoot();

            result.append(tree.getMaxDistance(root)).append("\n");

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