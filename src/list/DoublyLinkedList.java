package list;

public class DoublyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public void add(T element) {
        Node newNode = new Node(element);
        if (getSize() == 0) {
            head = tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    public T remove() {
        if (getSize() == 0) return null;
        Node<T> removedNode = tail;
        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        return removedNode.getData();
    }
    public int getSize() {
        return size;
    }
    private class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> next;
        private Node<T> previous;
        public Node(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
        public Node<T> getPrevious() {
            return previous;
        }
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
    public void reverseList () {
        Node tempHead = this.head;
        Node tempTail= this.tail;
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
        head=tempTail;
        tail=tempHead;
        head.previous=null;
        tail.next=null;
    }
    public void printList () {
        Node currentNode = head;
        System.out.print("start -> ");
        while (currentNode != null) {
            System.out.print(currentNode.getData()+" -> ");
            currentNode = currentNode.next;
        }
        System.out.print("end");
        System.out.println();
    }
    public void printReversedList () {
        Node currentNode = tail;
        System.out.print("end -> ");
        while (currentNode != null) {
            System.out.print(currentNode.getData()+" -> ");
            currentNode = currentNode.previous;
        }
        System.out.print("start");
        System.out.println();
    }
    public void mergeList(DoublyLinkedList<T> dl) {
        DoublyLinkedList<T> dl1 = this;
        DoublyLinkedList<T> dl2 = dl;
        Node dummyNode = new Node(null);
        Node tail = dummyNode;
        Node l1Node = dl1.head;
        Node l2Node = dl2.head;
        while (true) {
            if(l1Node==null){
                tail.next=l2Node;
                l2Node.previous=tail;
                break;
            }
            if(l2Node==null){
                tail.next=l1Node;
                l1Node.previous=tail;
                break;
            }
            if(l1Node.data.compareTo(l2Node.data) <= 0){
                tail.next=l1Node;
                l1Node.previous=tail;
                l1Node=l1Node.next;
            } else {
                tail.next=l2Node;
                l2Node.previous=tail;
                l2Node=l2Node.next;
            }
            tail=tail.next;
        }
        this.head=dummyNode.next;
        this.head.previous=null;
    }
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dl1 = new DoublyLinkedList<>();
        dl1.add(3);
        dl1.add(26);
        dl1.add(39);
//        sl.printList();
//        sl.reverseList();
//        sl.printList();
//        sl.printReversedList();

        DoublyLinkedList<Integer> dl2 = new DoublyLinkedList<>();
        dl2.add(13);
        dl2.add(17);
        dl1.mergeList(dl2);
        dl1.printList();
        dl1.printReversedList();
    }
}
