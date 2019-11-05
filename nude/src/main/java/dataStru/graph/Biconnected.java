package main.java.dataStru.graph;

public class Biconnected {

    public static Graph g;
    public static int count = 1;
    public static Graph.Vertex w;

    public static void main(String[] args) {
        String[] aa = {"A","B","C","D","E","F","G"};
        String[][] bb = {{"C","1","G"},{"A","1","D"},{"A","1","B"},{"B","1","C"},{"D","1","C"},{"D","1","F"},{"D","1","E"},{"E","1","F"}};
        g = new Graph(7,8,aa,bb,false);
        Graph.Vertex ve = g.verArray[0];
//        prim("V0",graph);
        g.verArray[0].parent=g.verArray[0];
        assignNum(ve);
        assignLow(ve);

//        findArt(ve);

        Graph.Vertex v;
        for(int i =0;i<g.verNum;i++){
            v = g.verArray[i];
            System.out.println(v.verName+":"+v.num+"/"+v.low+"   parent:"+v.parent.verName);
        }

    }



    public static void assignNum(Graph.Vertex v){
        v.num = count++;
        v.known=true;

        Graph.Edge e = v.edgeLink;
        while(e!=null){
             w= g.getVertex(e.tailName);
             if(!w.known){
                 w.parent=v;
                 assignNum(w);
             }
             e=e.broEdge;
        }
    }

    public static void assignLow(Graph.Vertex v){
        v.low = v.num;
        Graph.Edge e = v.edgeLink;
        while(e!=null){
            w= g.getVertex(e.tailName);
            if(w.num>v.num){
                assignLow(w);
                if(w.low>=v.num)
                    System.out.println(v.verName);
                v.low=v.low<w.low?v.low:w.low;
            }else
                if(v.parent != w)
                    v.low=v.low<w.num?v.low:w.num;


            e=e.broEdge;
        }
    }

    public static void findArt(Graph.Vertex v){

        v.known = true;
        v.low = v.num = count++;
        Graph.Edge e = v.edgeLink;
        while(e!=null){
            w= g.getVertex(e.tailName);

            if(!w.known){
                w.parent = v;
                findArt(w);
                if(w.low>=v.num)
                    System.out.println(v.verName);
                v.low=v.low<w.low?v.low:w.low;
            }else
            if(v.parent != w)
                v.low=v.low<w.num?v.low:w.num;

            e=e.broEdge;
        }
    }


}
