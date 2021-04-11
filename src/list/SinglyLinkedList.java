package list;

public class SinglyLinkedList<T extends Comparable<T>> {
    private int size;
    private Node<T> head;
    public void add(T t) {
        Node<T> newNode = new Node<>(t);
        if(isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }
    public int getSize() {
        return size;
    }
    public T remove () {
        if (isEmpty()) return null;
        Node<T> deletedNode = head;
        head = head.getNext();
        deletedNode.setNext(null);
        size--;
        return deletedNode.getData();
    }
    public boolean isEmpty () {
        return head == null;
    }
    public void printSinglyLinkedList () {
        System.out.print("Head -> ");
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData()+" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println(" End");
    }
    private class Node<T extends Comparable<T>> {
        private Node<T> next;
        private T data;
        public Node(T data) {
            this.data = data;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
        public T getData() {
            return data;
        }
    }
    public void reverseList () {
        Node prev=null;
        Node next=null;
        while (head != null) {
           next = head.next;
           head.next=prev;
           prev=head;
           head=next;
        }
        head=prev;
    }
    public void mergeList (SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> list1 = this;
        Node dummyNode = new Node(null);
        Node tail = dummyNode;
        Node l1Node = list1.head;
        Node l2Node = list2.head;
        while (true) {
            if(l1Node==null){
                tail.next=l2Node;
                break;
            }
            if(l2Node==null){
                tail.next=l1Node;
                break;
            }
            if(l1Node.data.compareTo(l2Node.data) <= 0){
                tail.next=l1Node;
                l1Node=l1Node.next;
            } else {
                tail.next=l2Node;
                l2Node=l2Node.next;
            }
            tail=tail.next;
        }
        this.head=dummyNode.next;
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<>();
        sl.add(3);
        sl.add(26);
        sl.add(39);
        SinglyLinkedList<Integer> sl2 = new SinglyLinkedList<>();
        sl2.add(13);
        sl2.add(17);
        sl.mergeList(sl2);
        sl.printSinglyLinkedList();
    }
}