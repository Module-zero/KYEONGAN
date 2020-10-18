package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Q15652 {
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        //        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        int[] arr = new int[m];
        sb = new StringBuilder();
        select(arr,0,m,n,1);
        System.out.println(sb);
    }
    public static void select(int[]arr, int cnt, int m,int n,int start){
        if(cnt == m){
            for(int num : arr){
                sb.append(num+" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = start ; i <= n; i++){
            arr[cnt] = i;
            select(arr,cnt+1,m,n,i);
        }
    }
}
