package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1699 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());

        long []dp = new long[n+1];
        dp[1] = 1;

        for(int i = 1 ; i <= n ; i ++){
            int num = 0;
            long min = 100001;
            for(int j = 1 ; j*j <= i; j++){
                num = j*j;
                if(min > 1+dp[i-num]){
                    min = 1+dp[i-num];
                }
            }
            dp[i] = min;
        }
        System.out.println(dp[n]);
    }

}
