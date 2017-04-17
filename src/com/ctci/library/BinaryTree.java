package com.ctci.library;

/**
 * Created by zambro on 4/16/17.
 */
public class BinaryTree {

    public static TreeNode getBinaryTree() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(100);
        TreeNode parentLeft = new TreeNode(3,left,right);

        left = new TreeNode(100);
        TreeNode parentRight = new TreeNode(34, left, null);

        TreeNode head = new TreeNode(10, parentLeft, parentRight);
        return head;
    }

    public static void printInOrder(TreeNode node) {
        if(node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public static void printPostOrder(TreeNode node) {
        if(node == null)
            return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data+ " ");
    }

    public static void printPreOrder(TreeNode node) {
        if(node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode head = getBinaryTree();
        System.out.println("Inorder: ");
        printInOrder(head);
        System.out.println("\nPostOrder: ");
        printPostOrder(head);
        System.out.println("\nPreOrder: ");
        printPreOrder(head);
    }
}
