package com.sirdave.data_structures;

public class FindSecondLargestTree {

    static int findLargestTree(BinaryTreeNode root){
        BinaryTreeNode current = root;
        while (current.right != null){
            current = current.right;
        }
        return current.value;
    }

    static int findSecondLargestNode(BinaryTreeNode root){
        if (root == null || (root.left == null && root.right == null)){
            throw new IllegalArgumentException("Tree must contain at least 2 nodes");
        }

        BinaryTreeNode current = root;
        while (true){

            if (current.left != null && current.right == null){
                return findLargestTree(current.left);
            }


            if (current.right != null && current.right.left == null
                    && current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }


    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(4);
        BinaryTreeNode b = new BinaryTreeNode(2);
        BinaryTreeNode c = new BinaryTreeNode(5);
        BinaryTreeNode d = new BinaryTreeNode(1);
        BinaryTreeNode e = new BinaryTreeNode(3);
        BinaryTreeNode f = new BinaryTreeNode(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        int secondLargest = findSecondLargestNode(a);
        int largest = findLargestTree(a);
        System.out.println(largest);
        System.out.println(secondLargest);
    }
}
