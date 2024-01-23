package BinaryTrees;

import java.util.Stack;

/*Approach
 * 1.first we put the root node in the stack.
 * 2.then we check the that its left node is there and is not null. if it is the case then we 
 * add it in the stack but if it incounters null values. so we pop the topmost element of the
 * stack and print it which temporarily stored in temp node. 
 * 3.And then we check thats wheather the right node is not null for the removed node.
 * 4.if if it is null then pop it from the stack and print it.
 */
public class depth1stAlgo {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static void dfs(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(st.size()>0){
            Node temp = st.peek();
            if(temp.left!=null){
                st.push(temp.left);
                temp.left = null; //VIMP - as it is making the tree visited and also breaking the tree bonds at the same time.
            }
            else{
                st.pop();
                System.out.print(temp.val + " ");
                if(temp.right!=null) st.push(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        // root.val = 1;
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
        b.right = f;
        b.left = e;
        dfs(root);
    }
}
