package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q10844 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        long n = Integer.parseInt(bf.readLine());
        long[][] dp = new long[101][11];
        for(int i = 0 ; i <= 9 ; i ++){
            dp[1][i] = 1;
        }
        long answer = 0;
        for(int i = 1 ; i<=n ; i ++){
            for(int j = 0 ; j <= 9 ; j++){
                if( i!= 1) {
                    switch(j){
                        case 0:
                            dp[i][j] = dp[i-1][j+1]%1000000000;
                            break;
                        case 9:
                            dp[i][j] = dp[i-1][j-1]%1000000000;
                            break;
                        default:
                            dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                            break;
                    }
                }
                if(i == n && j != 0){
                    answer = (answer + dp[i][j])%1000000000;
                }
            }
        }
        System.out.println(answer);
    }
}
