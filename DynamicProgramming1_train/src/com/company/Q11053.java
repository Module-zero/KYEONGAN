package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11053 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        long[] num = new long[n+1];
        long[] dp = new long[n+1];
        long max = 0;
        String[] strArr = bf.readLine().split(" ");
        for(int i = 1 ; i <= n ; i ++){
            num[i] = Integer.parseInt(strArr[i-1]);
            dp[i] =1;
            int target = 0;
            for(int j = i-1; j >0 ; j--){
                if(num[i]>num[j]){
                    if(num[target] < num[j] && dp[target] < dp[j]){
                        target = j;
                    }
                }
            }
            dp[i] = dp[target]+1;
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
