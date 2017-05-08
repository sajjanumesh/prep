package com.pc.stacks;

/**
 * Created by zambro on 5/8/17.
 * http://www.programcreek.com/2012/12/add-two-numbers/
 *
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class LinkedListsAddition {

    public static class Node{
        int data;
        Node next;

        public Node(){}
        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public static class LinkedList{
        Node top;

        public void add(int data) {
            Node node = new Node(data);
            if(top == null)
                top = node;
            else {
                Node last = top;
                while(last.next != null)
                    last = last.next;
                last.next = node;
            }
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            Node node = top;
            while(node != null) {
                sb.append(node.data+",");
                node = node.next;
            }
            if(sb.length()>0) sb.setLength(sb.length()-1);
            return sb.toString();
        }
    }

    public static Node addTwoReversedLists(Node top1, Node top2) {
        if(top1 == null)
            return top2;
        if(top2 == null)
            return top1;

        int carry = 0;
        Node top = null, last = null;
        while(top1 != null && top2 != null) {
            int result = top1.data + top2.data + carry;
            Node node = new Node(result%10);
            carry = result / 10;
            if(last == null) {
                top = node;
                last = node;
            } else {
                last.next = node;
                last = node;
            }
            top1 = top1.next;
            top2 = top2.next;
        }

        Node remaining = top1==null?top2:top1;

        while(remaining != null) {
            int result = remaining.data + carry;
            Node node = new Node(result%10);
            carry = result / 10;
            last.next = node;
            last = node;
            remaining = remaining.next;
        }

        if(carry != 0) {
            Node node = new Node(carry);
            last.next = node;
            last = node;
        }

        return top;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(8);
        list1.add(3);
        list1.add(4);
        list1.add(2);
        list1.add(1);
        System.out.println(list1.toString());
        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        System.out.println(list2.toString());

        Node top = addTwoReversedLists(list1.top, list2.top);
        while (top != null) {
            System.out.print(top.data+",");
            top = top.next;
        }
    }
}
