package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1912 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] strArr = bf.readLine().split(" ");
        int[] dp = new int[n+1];
        dp[0] = Integer.parseInt(strArr[0]);
        int max = dp[0];
        for(int i = 1 ; i < n ; i ++){
            int num = Integer.parseInt(strArr[i]);
            dp[i] = dp[i-1] > 0 ? dp[i-1]+ num : num;
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
