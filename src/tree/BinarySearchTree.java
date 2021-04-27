package tree;


import java.util.Optional;

public class BinarySearchTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.traverseInOrder();
        tree.delete(277);
        tree.traverseInOrder();

//        System.out.println(tree.isPresent(154));
//        System.out.println(tree.getMin());
//        System.out.println(tree.getMax());
    }

    private Node<T> root;

    public void insert (T data) {
        if (root == null) root = new Node<>(data);
        else root.insert(data);
    }

    public void delete (T value) {
       root = delete(root, value);
    }

    private Node<T> delete(Node<T> subTreeRoot, T value) {
        if (subTreeRoot == null) return subTreeRoot;
        if (value.compareTo(subTreeRoot.data) < 0) {
            subTreeRoot.leftChild = delete(subTreeRoot.leftChild, value);
        } else if (value.compareTo(subTreeRoot.data) > 0) {
            subTreeRoot.rightChild = delete(subTreeRoot.rightChild, value);
        } else {
            if (subTreeRoot.leftChild == null) return subTreeRoot.rightChild;
            else if (subTreeRoot.rightChild == null) return subTreeRoot.leftChild;

            subTreeRoot.data = subTreeRoot.rightChild.getMin();
            subTreeRoot.rightChild = delete(subTreeRoot.rightChild, subTreeRoot.data);
        }
        return subTreeRoot;
    }

    public boolean isPresent (T data) {
        if (root != null) return root.get(data) == null ? false : true;
        return false;
    }

    public T getMin () {
        if (root == null) return null;
        else return root.getMin();
    }

    public T getMax () {
        if (root == null) return null;
        else return root.getMax();
    }

    public void traverseInOrder () {
        if (root != null) root.traverseInOrder();
        System.out.println();
    }

    private class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;
        private Node(T data) { this.data = data;}
        private void insert (T data) {
            if (data.equals(this.data)) return; //no operation

            if (data.compareTo(this.data) < 0) {
                if (leftChild == null) leftChild = new Node<>(data);
                else leftChild.insert(data);
            } else {
                if (rightChild == null) rightChild = new Node<>(data);
                else rightChild.insert(data);
            }
        }
        private Node<T> get (T data) {
            if (this.data.equals(data)) return this;
            if (data.compareTo(this.data) < 0) {
                if (leftChild != null) return leftChild.get(data);
            }
            else {
                if ( rightChild!=null ) return rightChild.get(data);
            }
            return null;
        }
        private T getMin () {
            if (leftChild == null) return this.data;
            else return leftChild.getMin();
        }
        private T getMax () {
            if (rightChild == null) return this.data;
            else return rightChild.getMax();
        }
        public void traverseInOrder() {
//            System.out.print(this.data + " , ");  //pre-order
            if (leftChild != null) leftChild.traverseInOrder();
            System.out.print(this.data + " , ");
            if (rightChild != null) rightChild.traverseInOrder();
//            System.out.print(this.data + " , "); //post-order
        }

    }
}
