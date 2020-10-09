package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1463 {

    public static void main(String[] args) throws Exception{
//	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

	    int n = Integer.parseInt(bf.readLine());

	    int[] dp = new int[n+1];
	    for(int i = 2 ; i <= n ;i ++){
	        int num = dp[i-1] + 1;
			if(i % 2 == 0){
				if(dp[i/2] < num - 1){
					num = dp[i/2] + 1;
				}
			}
			if(i % 3 == 0){
				if(dp[i/3] < num - 1){
				 	num = dp[i/3] + 1;
				}
			}
			dp[i] = num;
        }
        System.out.println(dp[n]);
    }

}
