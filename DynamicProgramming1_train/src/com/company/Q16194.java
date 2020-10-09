package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16194 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] strArr= bf.readLine().split(" ");
        int[] dp = new int[n+1];
        for(int i = 1;i<=n ; i ++){
            dp[i] = Integer.parseInt(strArr[i-1]);
        }
        for(int i = 2 ; i <= n ; i ++){
            for(int j = 1; j <= i/2 ; j ++){
                int tmp = dp[i-j]+dp[j];
                if(dp[i] > tmp){
                    dp[i] = tmp;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
