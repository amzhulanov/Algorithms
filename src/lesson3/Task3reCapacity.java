package lesson3;

public class Task3reCapacity {
    public static void main(String[] args) {
        int sizeOld=0;
        MyStack<Integer> myStack=new MyStack<>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        sizeOld=myStack.size();
        System.out.println("Размер стека = "+sizeOld);
        for (int i = 0; i <sizeOld ; i++) {
            System.out.print(myStack.readList(i)+" ");
        }
        System.out.println();
        myStack.reCapacity(3);
        System.out.println("Размер стека изменён. Размер стека = "+myStack.getCapacity());
        for (int i = 0; i <myStack.size() ; i++) {
            System.out.print(myStack.readList(i)+" ");
        }

        myStack.push(13);
        myStack.push(14);
        myStack.push(15);
        System.out.printf("Добавлено %s элемента\n",myStack.size()-sizeOld);

    }
}
