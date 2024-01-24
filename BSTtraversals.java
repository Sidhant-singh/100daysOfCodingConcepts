package BinarySearchTrees;

public class BSTtraversals {
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

        public void inorderTraversal(Node root) {
            if (root != null) {
                inorderTraversal(root.left);
                System.out.print(root.key + " ");
                inorderTraversal(root.right);
            }
        }

        public void preorderTraversal(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
        }

        public void postorderTraversal(Node root) {
            if (root != null) {
                postorderTraversal(root.left);
                postorderTraversal(root.right);
                System.out.print(root.key + " ");
            }
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
        
        System.out.print("Inorder traversal: ");
        bst.inorderTraversal(bst.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        bst.preorderTraversal(bst.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        bst.postorderTraversal(bst.root);
        System.out.println();
    }
}
