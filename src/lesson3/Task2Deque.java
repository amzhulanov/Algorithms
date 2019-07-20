package lesson3;

public class Task2Deque {

    public static void main(String[] args) {
        Deque<Integer> deque=new Deque<>(5);
        deque.insertRight(1);
        System.out.println("Добавил справа: "+deque);
        deque.insertLeft(2);
        System.out.println("Добавил слева: "+deque);
        deque.insertRight(3);
        System.out.println("Добавил справа: "+deque);
        System.out.println("Удалил первый элемент: "+deque.removeFirst());
        System.out.println("Состояние стека: "+deque);
        System.out.println("Удалил последний элемент: "+deque.removeLast());
        System.out.println("Состояние стека: "+deque);
        deque.insertLeft(11);
        deque.insertLeft(12);
        deque.insertLeft(13);
        deque.insertLeft(27);
        System.out.println("Добавил слева 4 значения: "+deque);
        System.out.println("Удалил первый элемент: "+deque.removeFirst());
        System.out.println("Состояние стека: "+deque);
        System.out.println("Удалил последний элемент: "+deque.removeLast());
        System.out.println("Состояние стека: "+deque);


    }
}
