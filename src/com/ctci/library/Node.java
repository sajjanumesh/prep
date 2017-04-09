package com.ctci.library;

public class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

        public void setNext(Node next) {
            this.next = next;
        }
        public void printAll() {
            Node current = this;
            while(current.next != null) {
                System.out.print(current.data+"->");
                current = current.next;
            }
            System.out.println(current.data);
        }
    }