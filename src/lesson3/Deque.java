package lesson3;

public class Deque<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public Deque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Ёмкость = " + capacity);
        } else {
            list = (Item[]) new Object[capacity];
        }
    }

    public Deque() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(Item item) {
        if (isFull()) {
            throw new StackOverflowError("Очередь полна");

        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }


    public void insertLeft(Item item) {
        if (isFull()) {
            throw new StackOverflowError("Очередь полна");

        }
        for (int i = end; i > 0; i--) {
            list[i] = list[i - 1];
        }
        list[0] = item;
        size++;
        end = nextIndex(end);
    }

    public Item peekBegin() {
        if (isEmpty()) {
            throw new StackOverflowError("Очередь пустая");
        }
        return list[begin];
    }

    public Item peekEnd() {
        if (isEmpty()) {
            throw new StackOverflowError("Очередь пустая");
        }
        if (size > 1 && (end - 1) < 0) {
            return list[nextIndex(list.length - 1)];
        } else {
            return list[end - 1];
        }
    }

    public Item removeFirst() {
        Item tempItem = peekBegin();


        if (size > 1 && (end == 0)) {
            for (int i = 0; i < size-1; i++) {
                list[i] = list[i + 1];
            }
            list[size-1]=null;
            end = size-1;
        } else {
            for (int i = 0; i < end; i++) {
                list[i] = list[i + 1];
            }
            end = nextIndex(end - 2);
        }
        size--;
        return tempItem;
    }

    public Item removeLast() {
        Item tempItem = peekEnd();
        size--;
        list[end - 1] = null;
        end = nextIndex(end - 2);
        return tempItem;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;

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

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;

    }
}
