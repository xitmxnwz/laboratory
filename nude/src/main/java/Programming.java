package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programming {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countOff(7,2,3)));
    }
    //报数游戏
    public static int[] countOff(int N, int S, int M){
        int NN = N;
        int[] aa = new int[N];
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i]=i+1;
        }


        int pos=1;
        int z=1;
        int b = S % N;
        int c = M % N;
        int d = (b+c) % N -1 ;
        z=d;
        aa[0]=z;
        N--;

        a[d-1]=0;


        while(N>0){
            int e = M % N;

            for(int j=0;j<e;j++){
                z++;
                if(z>NN)
                    z=1;

                int q = z-1;
                if(q+1>NN) {
                    q = 0;
                }
                if(a[q]==0){
                    j--;
                }
            }

            aa[pos++]=z;
            a[z-1]=0;
            N--;
        }
        return aa;


    }


}
