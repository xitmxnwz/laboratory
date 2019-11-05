package main.java.dataStru.graph;

import java.util.LinkedList;
import java.util.Queue;



//广度优先搜索
public class MinDistUnWeight {

    public final static int INFINITY = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String[] aa = {"V0","V1","V2","V3"};
        String[][] bb = {{"V0","5","V3"},{"V1","3","V0"},{"V2","9","V0"},{"V1","6","V2"},{"V2","7","V3"}};
        Graph graph = new Graph(4,5,aa,bb,true);
        Graph.Vertex vv = graph.verArray[1];
        sort(graph,vv);
    }


    public static void sort(Graph graph,Graph.Vertex vv) {
        Queue q = new LinkedList();

        for(int i = 0; i<graph.verNum;i++){
            Graph.Vertex v = graph.verArray[i];
            v.dist=INFINITY;
        }
        vv.dist=0;
        q.offer(vv);


        while (!q.isEmpty()) {
            Graph.Vertex v = (Graph.Vertex) q.poll();

            Graph.Edge edg = v.edgeLink;
            while (edg != null) {
                Graph.Vertex w = graph.getVertex(edg.tailName);
                if (w.dist==INFINITY){
                    w.dist=v.dist+1;
                    w.path=v;
                    q.offer(w);
                }
                edg = edg.broEdge;
            }


        }

        for(int i =0;i<graph.verNum;i++){
            System.out.println(graph.verArray[i].dist);

        }


    }



}
