package main.java.dataStru.graph;

import java.util.LinkedList;
import java.util.Queue;
//加权最短路径
public class Dijkstra {
    public final static int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String[] aa = {"V0","V1","V2","V3","V4"};
        String[][] bb = {{"V0","5","V3"},{"V1","3","V0"},{"V2","9","V0"},{"V1","6","V2"},{"V2","7","V3"},{"V3","1","V4"},{"V2","5","V4"}};
        Graph graph = new Graph(5,7,aa,bb,true);
        Graph.Vertex ve = graph.verArray[1];
        sort(graph,ve);
    }


    public static void sort(Graph graph,Graph.Vertex ve) {
        Queue q = new LinkedList();

        for (int i = 0; i < graph.verNum; i++) {
            Graph.Vertex v = graph.verArray[i];
            v.dist = INFINITY;
            v.known = false;

        }


        ve.dist = 0;
        q.offer(ve);


        while (!q.isEmpty()) {
            Graph.Vertex v = (Graph.Vertex) q.poll();
            Graph.Edge edg = v.edgeLink;
            while (edg != null) {
                Graph.Vertex w = graph.getVertex(edg.tailName);
                q.offer(w);
                int newDis = v.dist+edg.weight;
                if (newDis < w.dist) {


                    w.dist = newDis;
                    w.path=v;
                }
                edg = edg.broEdge;
            }
        }

        System.out.println("-------------------------------");

        for (int i = 0; i < graph.verNum; i++) {
            Graph.Vertex v = graph.verArray[i];
            System.out.print("顶点："+v.verName+"   ");
            System.out.print("路径长："+v.dist+"    ");
            System.out.print("路径：");
            printPath(v);
            System.out.println();
        }

    }

    static void printPath(Graph.Vertex v){
        if(v.path != null){
            printPath(v.path);
            System.out.print(" -> ");
        }
        System.out.print(v.verName);
    }

}
