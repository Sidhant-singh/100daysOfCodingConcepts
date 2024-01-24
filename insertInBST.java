package BinarySearchTrees;
//leetcode - 701
public class insertInBST {

    public class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val =val;
        }
    }

    public static Node insertNode(Node root,int val){
        if(root==null) return new Node(val);

        if(root.val>val){//left side
            if(root.left==null) root.left = new Node(val);
            else{
                insertNode(root.left, val);
            }
        }
        else{ // right side
            if(root.right==null) root.right = new Node(val);
            else{
                insertNode(root.right, val);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
}
