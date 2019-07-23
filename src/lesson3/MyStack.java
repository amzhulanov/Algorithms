package lesson3;

public class MyStack<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Ёмкость = " + capacity);
        } else {
            list = (Item[]) new Object[capacity];
        }
    }

    public MyStack() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(Item item){
        if (isFull()){
            throw new StackOverflowError("Стек заполнен.");
        }
        list[size]=item;
        size++;
    }

    public Item pop(){
        Item tempItem=peek();
        size--;
        list[size]=null;
        return tempItem;
    }
    public Item peek() {
        if (isEmpty()){
            System.out.println("Стек пуст");
            return null;
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;

    }

    public void reCapacity(int newCapacity){//для изменения размера массива
        Item[] tempArray=(Item[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArray,0,newCapacity);
        size=newCapacity;
        list=tempArray;
    }

    public int getCapacity(){
        return list.length;
    }

    public Item readList(int i){
        return list[i];

    }
}

