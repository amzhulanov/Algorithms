package lesson4;

import java.util.Iterator;

public class DoubleLinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size = 0;

    public DoubleLinkedList() {

        this.first = null;
        this.last = null;

    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item>{

        Node current = new Node(null,first);


        @Override
        public boolean hasNext() {
            return current.getNext()!=null;
        }

        @Override
        public Item next() {
            current=current.getNext();
            return (Item) current.getValue();
        }

        @Override
        public void remove() {
            DoubleLinkedList.this.delete((Item) current.getValue());
        }

    }

    private class Node<Item> {

        private Item value;
        private Node next;
        private Node previous;


        public Node(Item value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Item value) {
            this.value = value;
        }


        public Item getValue() {
            return value;
        }

        public void setValue(Item value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Item getFirst() {
        return (Item) first.getValue();
    }

    public Item getLast() {
        return (Item) last.getValue();
    }

    public void insertFirts(Item item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (!isEmpty()) {
            first.setPrevious(newNode);
        } else {
            last = newNode;
        }
        first = newNode;
        size++;

    }
    public void insertLast(Item item) {
        Node newNode = new Node(item);
        //newNode.setNext(first);
        if (!isEmpty()) {
            newNode.setPrevious(last);
            last.setNext(newNode);
        } else {
            last = newNode;
            first=newNode;
        }
        last = newNode;
        size++;

    }

    public Item deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        if (isEmpty()) {
            last = null;

        } else {
            first.setPrevious(null);
        }
        size--;
        return (Item) oldFirst.getValue();
    }

    public Item deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = last;
        first = first.getNext();
        if (last.getPrevious()!=null) {
            last.getPrevious().setNext(null);

        } else {
            first=null;
        }
        last=last.getPrevious();
        size--;
        return (Item) oldLast.getValue();
    }

    public int indexOff(Item item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOff(item) > -1;
    }

    public void insert(int index, Item item) {
        if (index <= 0) {
            insertFirts(item);
            return;
        }
        if (index >= size) {
            insertLast(item);
            return;
        }
        Node current = first;
        int i = 0;

        while (i < index - 1) {
            current = current.getNext();
            i++;

        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;

    }

    public boolean delete(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            deleteFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }

        if (current==last){
            deleteLast();
            return true;
        }
        if (current.getNext() == null) {
            return false;
        }
        current.getPrevious().setNext(current.getNext());

        current.getNext().setPrevious(current.getPrevious());
        size--;
        return true;

    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder str = new StringBuilder();
        while (current != null) {
            str.append(current.getValue() + " ");
            current = current.getNext();
        }
        return str.toString();
    }
}
