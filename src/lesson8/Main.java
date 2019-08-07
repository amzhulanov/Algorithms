package lesson8;

public class Main {

    public static void main(String[] args) {
        ChainingHashMap<Integer,String> chainingHashMap=new ChainingHashMap<>();
   /*     chainingHashMap.put(1,"one");
        chainingHashMap.put(2,"two");
        chainingHashMap.put(3,"three");
        chainingHashMap.put(4,"four");
        System.out.println(chainingHashMap);*/

       // chainingHashMap.delete(2);
        //System.out.println(chainingHashMap);

        for (int i = 0; i <10 ; i++) {
            chainingHashMap.put(i,""+i);
        }
        System.out.println(chainingHashMap);
        System.out.println(chainingHashMap.get(10));

        //chainingHashMap.delete(5);
        //System.out.println(chainingHashMap);
/*
LinearProbingHashMap<Integer,String> linearProbingHashMap=new LinearProbingHashMap<>();
        linearProbingHashMap.put(1,"one");
        linearProbingHashMap.put(2,"two");
        linearProbingHashMap.put(3,"three");
        linearProbingHashMap.put(4,"four");
        System.out.println(linearProbingHashMap.get(3));
        for (int i = 0; i <7 ; i++) {
            linearProbingHashMap.put((int) (Math.random()*1000),""+i);
        }
        System.out.println(linearProbingHashMap);*/
    }
}
