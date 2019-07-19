package HomeWork2;

public class ArrayList<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEF_CAPACITY = 10;

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Ёмкость списка " + capacity);
        } else {
            list = (Item[]) new Comparable[capacity];
        }
    }
    public ArrayList() {
        list = (Item[]) new Comparable[DEF_CAPACITY];
    }

    public void add(Item item) {
        list[size] = item;
        size++;
    }

    public void add(int index, Item item) {
        if (index > size) {
            index = size;
        }
        if (index < 0) {
            index = 0;
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public Item get(int index) {
        return list[index];
    }

    public int size() {
        return size;
    }

    public boolean search(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        Item key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort(){
        boolean isSwap;
        for (int i = size-1; i >0 ; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if(less(list[j+1], list[j])){
                    swap(j+1,j);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += list[i] + " ";
        }
        return s;
    }

    public void set(int index, Item item) {
        list[index] = item;
    }

    public boolean delete(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }
}
