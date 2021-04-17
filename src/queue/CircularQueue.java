package queue;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private int top;
    private int bottom;
    private Object[] queue;
    public CircularQueue() {
        this.queue=new Object[3];
    }

    ////////////////////////////////////////////////////////

    public void add (T t) {
        if (size() == queue.length-1) {
            int bottom=size();
            Object[] newQueue = new Object[2* queue.length];
            System.arraycopy(queue, top, newQueue, 0, queue.length-top);
            System.arraycopy(queue, 0, newQueue, queue.length-top, bottom);
            queue=newQueue;
            this.bottom=bottom;
        }
        queue[bottom]=t;
        if (bottom < queue.length-1) bottom++;
        else bottom=0;
    }

    public T poll() {
        T t = (T) queue[top];
        queue[top++] = null;
        if(top == queue.length) top=0;
        else if (size()==0) top=bottom=0;
        return t;
    }

    ////////////////////////////////////////////////////////////////////////

    public void printCircularQueue() {
        if (bottom >= top) {
            for (int i=top; i<bottom; i++) System.out.print(queue[i]);
        } else {
            for (int i=top; i<queue.length; i++) System.out.print(queue[i]);
            for (int i=0; i<bottom;i++) System.out.print(queue[i]);
        }
    }
    public T peek() {
        if (size() == 0) throw new NoSuchElementException();
        return (T)queue[top];
    }
    public int size () {
        return top<=bottom ? bottom-top : bottom-top+ queue.length;
    }
    public void printTop() {
        System.out.println("Top : "+ top);
    }
    public void printBottom() {
        System.out.println("Bottm : "+ bottom);
    }

    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>();
        queue.add("Linku");
        queue.add("Tinku");
        queue.add("Pinku");
        queue.add("Rinku");
        queue.add("Chiku");
        System.out.println(queue.size());
        queue.printCircularQueue();
        System.out.println();
        System.out.println(queue.peek());
        System.out.println("-----------------");
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }


}
