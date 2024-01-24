package BinarySearchTrees;

public class deleteNode {

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BST {
        Node root;

        public BST() {
            root = null;
        }

        public void insert(int key) {
            root = insertRecursive(root, key);
        }

        public Node insertRecursive(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key)
                root.left = insertRecursive(root.left, key);
            else if (key > root.key)
                root.right = insertRecursive(root.right, key);

            return root;
        }

        public void preorderTraversal(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
        }

        public void deleteNode(Node root, int val) {
            // Base condition: If the root is null, return (nothing to delete)
            if (root == null) return;
        
            // If the value to be deleted is smaller, go to the left subtree
            if (root.key > val) {
                // If the left child is null, return (value not found)
                if (root.left == null) return;
        
                // If the left child's key is the value to be deleted
                if (root.left.key == val) {
                    Node l = root.left; //this node is to be deleted.
        
                    // If the node to be deleted has no children, simply set the left child to null
                    if (l.left == null && l.right == null) root.left = null; //its a leaf node.
                    // If the node has only one child, replace it with that child
                    else if (l.left == null || l.right == null) { //its a node with 1 child
                        if (l.left != null) root.left = l.left;
                        else root.left = l.right;
                    }
                }
                // If the value to be deleted is not found in the current node, recursively call on the left subtree
                else deleteNode(root.left, val);
            } else { // If the value to be deleted is larger, go to the right subtree
                // If the right child is null, return (value not found)
                if (root.right == null) return;
        
                // If the right child's key is the value to be deleted
                if (root.right.key == val) {
                    Node r = root.right;
        
                    // If the node to be deleted has no children, simply set the right child to null
                    if (r.left == null && r.right == null) root.right = null;
                    // If the node has only one child, replace it with that child
                    else if (r.left == null || r.right == null) {
                        if (r.left != null) root.right = r.left;
                        else root.right = r.right;
                    }
                }
                // If the value to be deleted is not found in the current node, recursively call on the right subtree
                else deleteNode(root.right, val);
            }
        }
        
    public static void main(String[] args) {
        BST bst = new BST();


        bst.insert(50);
        bst.insert(20);
        bst.insert(60);
        bst.insert(17);
        bst.insert(34);
        bst.insert(55);
        bst.insert(89);
        bst.insert(10);
        bst.insert(28);
        bst.insert(70);
        bst.insert(14);

        bst.preorderTraversal(bst.root);
        bst.deleteNode(bst.root,10);
        System.out.println();
        bst.preorderTraversal(bst.root);
    }
}
}
