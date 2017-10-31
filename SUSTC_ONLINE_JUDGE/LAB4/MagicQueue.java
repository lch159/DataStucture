package LAB4;

import java.util.Scanner;

public class MagicQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int operator = input.nextInt();
            int secondOperator = input.nextInt();
            Node2 node2 =new Node2(input.nextInt());
            for (int j = 1; j < n; j++) {
                operator = input.nextInt();
                secondOperator = input.nextInt();
                switch (operator) {
                    case 1:
                        if (secondOperator == 1) {
                            Node2 t1 = new Node2(input.nextInt());
                            node2.addLeft(t1);
                        } else {
                            node2.deleteFirst();
                        }
                        break;
                    case 2:
                        if (secondOperator == 1) {
                            Node2 t1 = new Node2(input.nextInt());
                            node2.addRight(t1);
                        } else {
                            node2.deleteLast();
                        }
                        break;
                }
            }
            node2.print();
        }
    }
}

class Node2 {
    private Node2 first;
    private Node2 end;
    private Node2 left;
    private Node2 right;
    private int data = 0;

    Node2(int n) {
        first = this;
        end = this;
        first.data = n;
    }

    //从头部添加
    void addLeft(Node2 before) {
        first.left = before;
        before.right = first;
        first = before;
    }

    //从尾部添加
    void addRight(Node2 after) {
        end.right = after;
        after.left = end;
        end = after;
    }

    void deleteFirst() {
        first = first.right;
        first.left = null;
    }

    void deleteLast() {
        end = end.left;
        end.right = null;
    }

    void print() {
        while (first != null) {
            System.out.println(first.data);
            first = first.right;
        }
    }
}