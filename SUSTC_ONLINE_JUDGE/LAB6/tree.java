package LAB6;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 11611423 李晨昊 on 2017/11/21.14:39
 */
//public class tree {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int T = input.nextInt();
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < T; i++) {
//            int num = input.nextInt();
//
//            BinaryTree tree = new BinaryTree();
//            for (int j = 0; j < num - 1; j++) {
//                tree.addNode(input.nextInt(), input.nextInt());
//            }
//
//
//        }
//    }
//}

//class BinaryTreeNode {
//    private int key;
//
//    private BinaryTreeNode parent = null;
//    private BinaryTreeNode left = null;
//    private BinaryTreeNode right = null;
//
//    public BinaryTreeNode(int value) {
//        this.key = value;
//    }
//
//    public BinaryTreeNode(int value, BinaryTreeNode parent) {
//        this.key = value;
//        this.parent = parent;
//    }
//
//    public BinaryTreeNode(int value, BinaryTreeNode parent, BinaryTreeNode left) {
//        this.key = value;
//        this.left = left;
//        this.parent = parent;
//    }
//
//    public BinaryTreeNode(int value, BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right) {
//        this.key = value;
//        this.left = left;
//        this.right = right;
//        this.parent = parent;
//    }
//
//    public void setParent(BinaryTreeNode parent) {
//        this.parent = parent;
//    }
//
//    public void setKey(int key) {
//        this.key = key;
//    }
//
//    public void setLeft(BinaryTreeNode left) {
//        this.left = left;
//    }
//
//    public void setRight(BinaryTreeNode right) {
//        this.right = right;
//    }
//
//    public int getKey() {
//        return key;
//    }
//
//    public BinaryTreeNode getLeft() {
//        return left;
//    }
//
//    public BinaryTreeNode getRight() {
//        return right;
//    }
//
//    public boolean isLeaf() {
//        return this.getLeft() == null && this.getRight() == null;
//    }
//
//    public boolean isFull() {
//        return this.getRight() != null && this.getLeft() != null;
//    }
//
//}

//class BinaryTree2 {
//    private Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
//    private LinkedList<Integer> parentList = new LinkedList<>();
//    private LinkedList<Integer> childList = new LinkedList<>();
//    private LinkedList<Integer> preOrder = new LinkedList<>();
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
//    private void setPreOrder(int root){
//        if (root!=0){
//            preOrder.add(root);
//            setPreOrder(this.getLeft(root));
//            setPreOrder(this.getRight(root));
//        }
//    }
//    LinkedList<Integer> getPreOrder(){
//        setPreOrder(this.getRoot());
//        return preOrder;
//    }
//
//    LinkedList<Integer> getInOrder(){
//        int inOrder_root= this.getRoot();
//        LinkedList<Integer> result =new LinkedList<>();
//        Stack<Integer> inOrder = new Stack<>();
//        while (inOrder_root != 0 || !inOrder.isEmpty()) {
//            while (inOrder_root != 0) {
//                inOrder.push(inOrder_root);
//                inOrder_root = this.getLeft(inOrder_root);
//            }
//            inOrder_root = inOrder.pop();
//            result.add(inOrder_root);
//            inOrder_root = this.getRight(inOrder_root);
//        }
//        return result;
//    }
//
//    LinkedList<Integer> getPostOrder(){
//        int postOrder_root=this.getRoot();
//        Stack<Integer> postOrder =new Stack<>();
//        Stack<Integer> postOrder2 =new Stack<>();
//        LinkedList<Integer> result =new LinkedList<>();
//        Integer p = 1;
//        while (postOrder_root!=0||!postOrder.empty()){
//            while (postOrder_root!=0){
//                postOrder.push(postOrder_root);
//                postOrder2.push(0);
//                postOrder_root=this.getLeft(postOrder_root);
//            }
//            while (!postOrder.empty()&&postOrder2.peek().equals(p)){
//                postOrder2.pop();
//                result.add(postOrder_root);
//            }
//            if (!postOrder.empty()){
//                postOrder2.pop();
//                postOrder2.push(1);
//                postOrder_root=postOrder.peek();
//                postOrder_root=this.getRight(postOrder_root);
//            }
//        }
//        return result;
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