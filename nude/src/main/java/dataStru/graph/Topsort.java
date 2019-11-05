package main.java.dataStru.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Topsort {
    public static void main(String[] args) {
        String[] aa = {"V0","V1","V2","V3"};
        String[][] bb = {{"V0","5","V3"},{"V1","3","V0"},{"V2","9","V0"},{"V1","6","V2"},{"V2","7","V3"}};
        Graph graph = new Graph(4,5,aa,bb,true);
        tops(graph);
    }


    public static void tops(Graph graph){
        Queue q = new LinkedList();
        int counter = 0;

        for(int i = 0; i<graph.verNum;i++){
            Graph.Vertex v = graph.verArray[i];
            if(v.indegree ==0 )
                q.offer(v);
        }

        while(!q.isEmpty()){
            Graph.Vertex v = (Graph.Vertex)q.poll();
            v.topNum = ++counter;


            Graph.Edge edg = v.edgeLink;
            while (edg != null){
                Graph.Vertex anoV = graph.getVertex(edg.tailName);
                if(--anoV.indegree == 0)
                    q.offer(anoV);
                edg=edg.broEdge;
            }


        }

        for(int i = 1; i<=graph.verNum;i++){
            for(int j =0;j<graph.verNum;j++){
                Graph.Vertex v = graph.verArray[j];
                if(v.topNum ==i ){
                    System.out.println(v.verName);
                    break;
                }

            }
        }


    }

}
