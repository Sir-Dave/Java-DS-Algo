package com.sirdave.data_structures;

import java.util.ArrayDeque;


public class NodeBounds {
    private final BinaryTreeNode root;
    private final int lowerBound;
    private final int upperBound;


    public NodeBounds(BinaryTreeNode root, int lowerBound, int upperBound){
        this.root = root;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    static boolean isBinaryNodeValid(BinaryTreeNode root){
        ArrayDeque<NodeBounds> stack = new ArrayDeque<>();
        stack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!stack.isEmpty()){
            NodeBounds nodeBounds = stack.pop();
            BinaryTreeNode node = nodeBounds.root;
            int lowerBound = nodeBounds.lowerBound;
            int upperBound = nodeBounds.upperBound;


            if (node.value <= lowerBound || node.value >= upperBound)
                return false;

            if (node.left != null){
                stack.push(new NodeBounds(node.left, lowerBound, node.value));
            }

            if (node.right != null){
                stack.push(new NodeBounds(node.right, node.value, upperBound));

            }
        }

        return true;
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
        //c.left = new BinaryTreeNode(2);

        System.out.println(isBinaryNodeValid(a));
    }
}
