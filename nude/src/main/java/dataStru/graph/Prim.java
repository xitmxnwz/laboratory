package main.java.dataStru.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Prim {
    private static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String[] aa = {"V0","V1","V2","V3"};
        String[][] bb = {{"V0","5","V3"},{"V1","3","V0"},{"V2","9","V0"},{"V1","6","V2"},{"V2","4","V3"}};
        Graph graph = new Graph(4,5,aa,bb,false);
        Graph.Vertex ve = graph.verArray[1];
//        prim("V0",graph);
        prim(0,graph);
    }

    /** 普通方法
     * @param start
     * @param g
     */
    public static void prim(int start,Graph g){

        int min,i,j,k=0,l=start,num = g.verNum,tmp,index=0,sum=0;
        Graph.Vertex[] prims = new Graph.Vertex[num];  // prim最小树的结果数组
        int[] weights = new int[num];  // 顶点间边的权值

        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
        prims[index++] = g.verArray[start];
        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (i = 0; i < num; i++ )
            weights[i] = INF;

        for (i = 0; i < num; i++) {
            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
            if(start == i)
                continue;
            min = INF;
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
            for (j=0;j < num;j++) {

                tmp = Graph.getWeight(l, j,g);
                // 当第j个节点没有被处理，并且需要更新时才被更新。
                if (weights[j] != 0 && tmp < weights[j])
                    weights[j] = tmp;

                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
            }
            sum+=min;
            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = g.verArray[k];
            l=k;
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[k] = 0;
        }

        // 打印最小生成树
//        System.out.printf("PRIM(%c)=%d: ", g.verArray[start].verName, sum);
        System.out.println(g.verArray[start].verName);
        System.out.println(sum);
        for (i = 0; i < index; i++)
            System.out.println(prims[i].verName);
        System.out.printf("\n");

    }





}
