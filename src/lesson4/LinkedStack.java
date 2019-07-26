package lesson4;

public class LinkedStack<T> {
    private DoubleLinkedList<T> stack=new DoubleLinkedList<>();

    public void push(T value){
        stack.insertFirts(value);
    }

    public T pop(){
        return stack.deleteLast();
    }

    public T peek(){
        return  stack.getFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();

    }


}
