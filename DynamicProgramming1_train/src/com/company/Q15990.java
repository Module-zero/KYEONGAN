package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q15990 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        long[][] dp = new long[100001][4];
        dp[1][1] =1;
        dp[2][2] =1;
        dp[3][3] =1;
        for(int i = 0 ; i < t ; i ++){
            int num = Integer.parseInt(bf.readLine());
            for(int j = 3; j <= num ; j ++){
                for(int k = 1 ; k <= 3; k ++){
                    if(dp[j][0] == -1){
                        continue;
                    }
                    int tmp = j-k;
                    if(tmp >= 0){
                        dp[j][k] += ((dp[tmp][1]+dp[tmp][2]+dp[tmp][3]-dp[tmp][k])%1000000009);
                    }
                }
                dp[j][0]=-1;
            }
            System.out.println((dp[num][1]+dp[num][2]+dp[num][3])%1000000009 );
        }


    }

}
