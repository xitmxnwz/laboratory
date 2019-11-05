package main.java.dataStru.graph;

import dataStructure.BinaryHeap;
import dataStructure.UnderflowException;
import main.java.dataStru.disjSets.DisjSets;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    public static void main(String[] args) {
        String[] aa = {"V0","V1","V2","V3","V4"};
        String[][] bb = {{"V0","5","V3"},{"V1","3","V0"},{"V2","9","V0"},{"V1","6","V2"},{"V2","4","V3"},{"V2","2","V4"}};
        Graph graph = new Graph(5,6,aa,bb,false);
        Graph.Vertex ve = graph.verArray[1];
//        prim("V0",graph);
        kruskal(graph);
    }

    public static void kruskal(Graph g){
        int sum=0,vNum = g.verNum;
        DisjSets ds = new DisjSets(vNum);
        Graph.Edge[] edgeArray = new Graph.Edge[g.edgeNum];
        PriorityHeap pq = new PriorityHeap(g.edgeArray);
        List mst = new ArrayList();

        while(mst.size() != vNum-1){
            Graph.Edge e = pq.deleteMin();
            int uset = ds.find(g.getPosition(g.getVertex(e.tailName)));
            int vset = ds.find(g.getPosition(g.getVertex(e.headName)));
            if(uset != vset){
                sum+=e.weight;
                mst.add(e);
                ds.union(uset,vset);
            }
        }
        System.out.println(sum);
    }



//    堆实现
    public static class PriorityHeap{
        private int currentSize;
        private Graph.Edge [ ] array;
        public PriorityHeap( Graph.Edge [ ] items )
        {
            currentSize = items.length;
            array =  new Graph.Edge[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( Graph.Edge item : items )
                array[ i++ ] = item;
            buildHeap( );
        }
        private void buildHeap( )
        {
            for( int i = currentSize / 2; i > 0; i-- )
                percolateDown( i );
        }
        private void percolateDown( int hole )
        {
            int child;
            Graph.Edge tmp = array[ hole ];

            for( ; hole * 2 <= currentSize; hole = child )
            {
                child = hole * 2;
                if( child != currentSize &&
                        array[ child + 1 ].weight< array[ child ].weight )
                    child++;
//            array[hole]=array[child];
                if( array[ child ].weight<tmp.weight )
                    array[ hole ] = array[ child ];
                else
                    break;
            }
            array[ hole ] = tmp;
        }
        public Graph.Edge deleteMin( )
        {
            if( isEmpty( ) )
                throw new UnderflowException( );

            Graph.Edge minItem = findMin( );
            array[ 1 ] = array[ currentSize-- ];
            percolateDown( 1 );

            return minItem;
        }
        public boolean isEmpty( )
        {
            return currentSize == 0;
        }
        public Graph.Edge findMin( )
        {
            if( isEmpty( ) )
                throw new UnderflowException( );
            return array[ 1 ];
        }
    }

}
