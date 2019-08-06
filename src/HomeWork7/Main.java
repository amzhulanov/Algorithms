package HomeWork7;

public class Main {

    public static void main(String[] args) {
        Graph graph=new Graph(10);
        for (int i=0;i<9;i++){
            graph.addEdge( (int) (Math.random()*10), (int) (Math.random()*10));
        }

        BreadFirstPath bfp=new BreadFirstPath(graph,2);
        System.out.println(bfp.distTo(4));
    }
}
