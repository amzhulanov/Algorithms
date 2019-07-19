package HomeWork2;

public class Main {


    private static ArrayList<Integer> mal;

    public static void main(String[] args) {
        long timeStart;

        fillArray();
        timeStart = System.nanoTime();
        mal.insertionSort();
        System.out.printf("Время выполнения сортировки вставкой %d ms%n", System.nanoTime() - timeStart);

        fillArray();
        timeStart = System.nanoTime();
        mal.selectionSort();
        System.out.printf("Время выполнения сортировки выбором %d ms%n", System.nanoTime() - timeStart);

        fillArray();
        timeStart = System.nanoTime();
        mal.bubbleSort();
        System.out.printf("Время выполнения пузырьковой сортировки %d ms%n", System.nanoTime() - timeStart);
    }

    private static void fillArray() {
        mal = new ArrayList(1000000);
        for (int i = 0; i < 100; i++) {
            mal.add(i + (int) (Math.random() * 10));
        }
    }


}
