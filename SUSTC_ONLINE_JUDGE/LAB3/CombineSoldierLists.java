package LAB3;

import java.util.Scanner;

class Node {
    int value;
    Node next=null;

    public Node(){}
    Node(int value){
        this.value=value;
    }
    public Node(int value, Node next){
        this.value=value;
        this.next=next;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}

public class CombineSoldierLists {
    private static Node mergeTwoSortedList(Node head1, Node head2){
        if(head1==null && head2==null)
            return null;
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        Node head=null;
        if(head1.value<head2.value){
            head=head1;
            head1.next=mergeTwoSortedList(head1.next,head2);    //递归
        }else{
            head=head2;
            head2.next=mergeTwoSortedList(head1,head2.next);    //递归
        }
        return head;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {


            int n = input.nextInt();
            int m = input.nextInt();
            int data1[]=new int[n];
            int data2[]=new int[m];

            for (int j=0;j<n;j++)
            {
                data1[j]=input.nextInt();
            }

            for (int j=0;j<m;j++)
            {
                data2[j]=input.nextInt();
            }

            Node head1=new Node(data1[0]);  //新建链表的头结点
            Node head1_1=head1;             //保留链表的头结点
            for(int j=1;j<data1.length;j++){ //用尾插法创建一个链表
                Node node1=new Node(data1[j]);
                head1.next=node1;
                head1=node1;
            }

            Node head2=new Node(data2[0]);  //新建链表的头结点
            Node head2_1=head2;             //保留链表的头结点
            for(int j=1;j<data2.length;j++){ //用尾插法创建一个链表
                Node node1 = new Node(data2[j]);
                head2.next = node1;
                head2 = node1;
            }
            Node node = mergeTwoSortedList(head1_1, head2_1);
            while (node.next != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println(node.value);
        }
    }
}
