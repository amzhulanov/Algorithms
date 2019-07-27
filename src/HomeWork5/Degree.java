package HomeWork5;

public class Degree {

    public static void main(String[] args) {
        int a=6;
        int deg=3;
        long timeStart;


        timeStart = System.currentTimeMillis();
        System.out.printf("%d в степени %d = %d ",a,deg,degree(a,1,deg));
        System.out.printf("Время расчёта степени циклом %d ms\n", System.currentTimeMillis() - timeStart);

        timeStart = System.currentTimeMillis();
        System.out.printf("%d в степени %d = %d ",a,deg,recDegree(a,1,deg));
        System.out.printf("Время расчёта степени рекурсией %d ms\n", System.currentTimeMillis() - timeStart);
    }


    public static int degree(int a,int res,int m){

        for (int i = 1; i <=m ; i++) {
            res*=a;
        }
        return res;
    }

    public static int recDegree(int a,int res,int m){
        if (m<=1){
            return res*a;
        }
        return recDegree(a,res*a,m-1);
    }
}
