package BinarySearchTrees;
import java.util.*;
public class searchBST {

    public class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val =val;
        }
    }
    public static Node searchBST(Node root,int val){
        if(root==null) return null;
        if(root.val == val) return root;
        else if(root.val>val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
    public static void main(String[] args) {
        
    }
}
