package main.java.dataStru.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    public static void main(String[] args) {
        String[] aa = {"V0","V1","V2","V3"};
        String[][] bb = {{"V0","5","V3"},{"V1","3","V0"},{"V2","9","V0"},{"V1","6","V2"},{"V2","7","V1"}};
        Graph graph = new Graph(4,5,aa,bb);


        System.out.println("该图的邻接表为：");
        outputGraph(graph);
    }



    /**
     * 图的节点个数
     */
    int verNum;
    /**
     * 图的边的条数
     */
    int edgeNum;
    /**
     * 图的邻接表中存储节点的数组
     */


    Vertex[] verArray;

    /**
     * Graph类的构造方法，依次读取节点、边等信息，完成图的构建。
     */
    public Graph(int verN,int edgeN,String[] verList,String[][] edgeList) {
//        Scanner scan = new Scanner(System.in);
        System.out.println("请输入节点个数和边的个数：");
        verNum = verN;
        edgeNum = edgeN;
        verArray = new Vertex[verNum];

        System.out.println("请依次输入节点的名称:");
        for (int i=0;i<verNum;i++){
            Vertex vertex = new Vertex();
            vertex.verName = verList[i];
            vertex.edgeLink = null;
            verArray[i] = vertex;
        }

        System.out.println("请按‘头节点 权值 尾节点 回车’的形式依次输入边的信息");
        for (int i=0;i<edgeNum;i++){
            String preName = edgeList[i][0];
            int weight = Integer.parseInt(edgeList[i][1]);
            String folName = edgeList[i][2];

            Vertex preV = getVertex(preName);
            Vertex folV = getVertex(folName);
            if (preV == null || folV == null){
                System.out.println("输入错误，输入了不存在的顶点！请重新输入");
                i--;
                continue;
            }
            folV.indegree++;

            Edge edge = new Edge();
            edge.tailName = folName;
            edge.weight = weight;

            //将边加入到节点的链表中去
            edge.broEdge = preV.edgeLink;
            preV.edgeLink = edge;

//            如果加上下面这段，则创建的是无向图，不加则是有向图
//            edge.tailName = preName;
//            edge.broEdge  = folV.edgeLink;
//            folV.edgeLink = edge;
        }
    }



    /**
     * 输出图的邻接表的方法。
     * @param graph 要输出的图
     */
    public static void outputGraph(Graph graph){
        for (int i=0;i<graph.verNum;i++){
            Vertex vertex = graph.verArray[i];
            System.out.print(vertex.verName);

            Edge current = vertex.edgeLink;
            while (current != null){
                System.out.print("--"+current.weight+"-->"+current.tailName);
                current = current.broEdge;
            }
            System.out.println();
        }
    }


    /**
     * 根据节点名称获取该节点
     * @param verName 节点的名称
     * @return 节点或null
     */
    public Vertex getVertex(String verName){
        for (int i=0;i<verNum;i++){
            if (verArray[i].verName.equals(verName))
                return verArray[i];
        }
        return null;
    }



    public class Vertex {
        /**
         * 节点存储的内容
         */
        String verName;
        /**
         * 顶点的边链
         */
        Edge edgeLink;

        //    入度
        int indegree;
//        拓扑排序数
        int topNum;
        //到起始点最短距离
        int dist;
        //路径
        Vertex path;
//        Dijkstra使用
        boolean known;



    }

    public class Edge {
        /**
         * 边的尾部节点名称
         */
        String tailName;
        /**
         * 边的权值
         */
        int weight;
        /**
         * 头节点的其他边
         */
        Edge broEdge;
    }


}


//    测试数据
//        请输入节点个数和边的个数：
//        4 5
//        请依次输入节点的名称:
//        V0 V1 V2 V3
//        请按‘头节点 权值 尾节点 回车’的形式依次输入边的信息
//        V0 5 V3
//        V1 3 V0
//        V2 9 V0
//        V1 6 V2
//        V2 7 V1
//        该图的邻接表为：
//        V0--5-->V3
//        V1--6-->V2--3-->V0
//        V2--7-->V1--9-->V0
//        V3