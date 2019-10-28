package main.java.algorithm;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //第一段音频长度
        int n = sc.nextInt();
        int [] musicOne = new int [n];
        //第一段音频音高
        for(int i = 0; i < n; i++){
            musicOne[i]= sc.nextInt();
        }
        //第二段音频长度
        int m = sc.nextInt();
        int[] musicTwo=new int [m];
        //第二段音频音高
        for(int i = 0; i < m; i++){
            musicTwo[i]= sc.nextInt();
        }
        Long minDifference=Long.MAX_VALUE;
        for (int i=0;i<m-n;i++){
            Long sum=0L;
            for (int j=0;j<n;j++){
//                System.out.println(i+j);
                sum+= (musicTwo[i+j]-musicOne[j])*(musicTwo[i+j]-musicOne[j]);
            }
            if (sum<minDifference){
                minDifference=sum;
            }
        }
        System.out.println(minDifference);
    }
}
