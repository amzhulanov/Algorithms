package HomeWork6;

public class Main {


    public static void main(String[] args) {
        final int COUNT=30;
        final int DEEP=6;
        BST[] arrayOfBST ;
        arrayOfBST=new BST[COUNT];
        int[] arrayMark=new int [COUNT];
        int value=0;
        for (int n = 0; n <COUNT ; n++) {
            arrayOfBST[n]=new BST<Integer,Integer>();
            do{
                value=(int) (Math.random()*200-100);
                arrayOfBST[n].put(value,value);
            }
            while (arrayOfBST[n].getDeep()<DEEP);
        }
        int mark=0;
        for (int i = 0; i <arrayOfBST.length ; i++) {
            System.out.print(arrayOfBST[i]);
            if (Math.abs(arrayOfBST[i].getDeepLeft()-arrayOfBST[i].getDeepRight())>1) {//рассчитываю сбалансированные деревья
                mark++;
                System.out.print(" - Дерево не сбалансировано.\n");
            }else{
                System.out.print(" - Дерево сбалансировано.\n");
            }
        }
        System.out.println("не сбалансированных деревьев = "+((mark*100)/COUNT)+"%");


    }
}
