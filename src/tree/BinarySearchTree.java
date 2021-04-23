package tree;



public class BinarySearchTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(25);
        tree.insert(24);
        tree.insert(26);
        tree.insert(28);
        tree.insert(19);
        System.out.println(tree);
    }

    private Node<T> root;

    public void insert (T data) {
        if (root == null) root = new Node<>(data);
        else root.insert(data);
    }

    private class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;
        Node(T data) { this.data = data;}
        void insert (T data) {
            if (data.compareTo(this.data) == 0) return; //no operation

            if (data.compareTo(this.data) < 0) {
                if (leftChild == null) leftChild = new Node<>(data);
                else leftChild.insert(data);
            } else {
                if (rightChild == null) rightChild = new Node<>(data);
                else rightChild.insert(data);
            }
        }
    }
}
