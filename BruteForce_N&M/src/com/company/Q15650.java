package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q15650 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        int[] answer = new int[m];
        select(0,m,answer,n,1);
    }
    public static void select(int cnt,int m,int[] answer, int n,int selNum){
        if(cnt == m){
            for(int tmp : answer){
                System.out.print(tmp+" ");
            }
            System.out.println("");
            return;
        }
        if(selNum > n){
            return;
        }
        answer[cnt] = selNum;
        select(cnt+1,m,answer,n,selNum+1);
        select(cnt,m,answer,n,selNum+1);
    }
}
