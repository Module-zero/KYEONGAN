package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q15649 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        boolean[] check = new boolean[n+1];
        int[] answer = new int[m];
        dfs(check,0,m,answer);
    }
    public static void dfs(boolean[] check, int cnt,int m,int[] answer){
        if(cnt == m){
            for(int tmp : answer){
                System.out.print(tmp+" ");
            }
            System.out.println("");
            return;
        }
        for(int i = 1 ; i < check.length ; i++){
            if(!check[i]){
                check[i] = true;
                answer[cnt++] = i;
                dfs(check,cnt,m,answer);
                --cnt;
                check[i] = false;
            }
        }
    }
}
