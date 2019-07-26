package lesson4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
       // LinkedList<String> linkedList=new LinkedList<>();
       /* linkedList.insertFirts("Maria");
        linkedList.insertFirts("Petr");
        linkedList.insertFirts("Kate");*/


  /*      System.out.println(linkedList);

     //   System.out.println(linkedList.deleteFirst());
     //   System.out.println(linkedList.deleteFirst());
        System.out.println(linkedList.delete("Petr"));
        System.out.println(linkedList);
        linkedList.insert(-6,"Max");
        System.out.println(linkedList);
*/


        DoubleLinkedList<String> doubleLinkedList=new DoubleLinkedList<>();

        doubleLinkedList.insertFirts("Fedor");
        doubleLinkedList.insertFirts("Sasha");
        doubleLinkedList.insertFirts("Maria");
        doubleLinkedList.insertLast("Grisha");
        //System.out.println(doubleLinkedList.deleteLast());
        //doubleLinkedList.delete("Sasha");
        System.out.println("Вывод doubleLinkedList: "+doubleLinkedList);

        Iterator<String> iterator=doubleLinkedList.iterator();
        System.out.print("Вывод итератора: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+", ");
        }




    }
}
