package HomeWork5;

public class Bag {
    private static float[] price = new float[4];
    private static int[] cost = {2, 7, 3, 5};//стоимость вещи
    private static int[] weight = {4, 10, 2, 7};//вес вещи
    private final static int WEIGHT_BAG = 15;

    public static void main(String[] args) {

        System.out.println("Исходные данные вещей (стоимость/вес): ");

        for (int j = 0; j < cost.length; j++) {
            System.out.print("(" + cost[j] + "/" + weight[j] + ") ");
        }

        for (int i = 0; i < cost.length; i++) {//определяю ценность 1 кг, приоритет вещи
            price[i] = (float) cost[i] / weight[i];
        }
        bubbleSort();
        System.out.println("\nРезультат сортировки по ценности 1 кг (стоимость/вес): ");
        for (int j = cost.length - 1; j >= 0; j--) {
            System.out.print("(" + cost[j] + "/" + weight[j] + ") ");
        }

        int i = weight.length - 1;
        int sum = 0;
        System.out.printf("\nВместимость рюкзака %d кг, в него влезли вещи (стоимость/вес):", WEIGHT_BAG);
        while (i >= 0) {
            if (sum + weight[i] <= WEIGHT_BAG) {
                sum += weight[i];
                System.out.print("(" + cost[i] + "/" + weight[i] + ") ");
            }
            i--;
        }
    }

    public static void bubbleSort() {
        boolean isSwap;
        for (int i = price.length - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (price[j + 1] < price[j]) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    private static void swap(int index1, int index2) {
        float temp = price[index1];
        price[index1] = price[index2];
        price[index2] = temp;

        temp = cost[index1];
        cost[index1] = cost[index2];
        cost[index2] = (int) temp;

        temp = weight[index1];
        weight[index1] = weight[index2];
        weight[index2] = (int) temp;
    }
}
