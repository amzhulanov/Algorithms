package lesson4;

public class LinkedQueue<T> {
    private DoubleLinkedList<T> queue=new DoubleLinkedList<>();

    public void enqueue(T value){
        queue.insertFirts(value);
    }

    public T dequeue(){
        return queue.deleteLast();
    }

    public T peek(){
        return  queue.getFirst();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();

    }
}
