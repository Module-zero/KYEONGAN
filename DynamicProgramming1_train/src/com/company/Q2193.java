package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2193 {
    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader( new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        long[][] dp = new long[91][2];
        dp[1][1] = 1;
        dp[1][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0 ; j <= 1; j++){
                if(i != 1){
                    dp[i][j]=dp[i-1][0];
                    if(j != 1){
                        dp[i][j]+=dp[i-1][1];
                    }
                }
            }
        }
        System.out.println(dp[n][1]);

    }
}
