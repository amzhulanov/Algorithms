package HomeWork7;


import HomeWork7.Graph;

import java.util.LinkedList;

public class BreadFirstPath {

    private boolean[] marked;
    private int[] edgTo;
    private int[] distTo;
    private int source;
    private final int INFINITY=Integer.MAX_VALUE;

    public BreadFirstPath(Graph graph, int source) {
        this.source = source;
        edgTo=new int[graph.getVertexCount()];
        distTo=new int[graph.getVertexCount()];
        marked=new boolean[graph.getVertexCount()];

        for (int i = 0; i <distTo.length ; i++) {
            distTo[i]=INFINITY;
        }

        BFS(graph,source);
    }

    private void BFS (Graph graph,int source){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.addLast(source);
        marked[source]=true;
        distTo[source]=0;
        while (!queue.isEmpty()){
            int vertex=queue.removeFirst();
            for (int w:graph.getAdjList(vertex)){
                if (!marked[w]){
                    marked[w]=true;
                    edgTo[w]=vertex;
                    distTo[w]=distTo[vertex]+1;
                    queue.addLast(w);
                }
            }

        }


    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        LinkedList<Integer> stack=new LinkedList<>();
        int vertex=v;
        while(vertex!=source){
            stack.push(vertex);
            vertex=edgTo[vertex];

        }
        return stack;

    }

    public int distTo(int v){
        return distTo[v];
    }
}
