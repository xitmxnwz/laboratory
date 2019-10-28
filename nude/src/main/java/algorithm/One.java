package main.java.algorithm;

import java.util.Scanner;

public class One {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] nn = new int[n];
       for(int i =0;i<n;i++){
          nn[i] = in.nextInt();
       }
        int m = in.nextInt();
        int zz=Integer.MAX_VALUE;
        int sum = 0;
        int[] mm = new int[m];
        for(int i = 0;i<m;i++){
            mm[i]=in.nextInt();
            if(i>n-2) {
                for(int j=i;j>i+1-n;j--){
                    sum+=(nn[j-i+n-1]-mm[j])*(nn[j-i+n-1]-mm[j]);
                }
                if(sum<zz)
                    zz=sum;
                sum=0;
            }
        }

        System.out.println(zz);



    }



}
