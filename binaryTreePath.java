package BinaryTrees;

import BinaryTrees.traversals.Node;

public class binaryTreePath {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static void binaryTreePath(Node root,String s){
        if(root==null) return;
        if(root.left==null && root.right==null){
            s+= root.val;
            System.out.println(s);
            return;
        }

        binaryTreePath(root.left, s+root.val + "->");
        binaryTreePath(root.right, s+root.val + "->");
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        Node f = new Node(7);
        b.left = e;
        b.right = f;
        binaryTreePath(root, "");
    }
}
