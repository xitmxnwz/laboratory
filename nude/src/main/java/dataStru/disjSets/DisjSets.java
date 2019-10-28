package main.java.dataStru.disjSets;

public class DisjSets {

    private static int[] s;

    public static void main(String[] args) {
       DisjSets ds = new DisjSets(8);
       ds.unionBySize(4,5);
       ds.unionBySize(6,7);
       ds.unionBySize(4,6);
        ds.unionBySize(3,4);

       for(int i =0;i<8;i++){
           System.out.println(s[i]);
       }
    }


    public DisjSets(int numElements){
       s = new int[numElements];
       for(int i = 0;i<s.length;i++){
           s[i] = -1;

       }

    }
//    普通求并
    public void union(int root1,int root2){
        s[root2] = root1;
    }
//按大小求并
    public void unionBySize(int root1,int root2){
        if(s[root1]<=s[root2]){
            s[root1]+=s[root2];
            s[root2]=root1;
        }else{
            s[root2]+=s[root1];
            s[root1]=root2;
        }
    }
//    按高度求并
    public void unionByHeight(int root1,int root2){
        if(s[root2]<s[root1])
            s[root1]=root2;
        else{
            if(s[root1]==s[root2])
                s[root1]--;
            s[root2]=root1;
        }
    }
//   找出该索引元素的根元素的索引（普通方式）
    public int find(int x){
        if(s[x]<0)
            return x;
        else
            return find(s[x]);
    }
//    路径压缩find方法
    public int newFind(int x){
        if(s[x]<0)
            return x;
        else
            return s[x]=find(s[x]);
    }


}
