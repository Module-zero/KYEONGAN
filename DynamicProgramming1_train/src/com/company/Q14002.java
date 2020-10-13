package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q14002 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader( new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[]strArr= bf.readLine().split(" ");
        long[] num = new long[n+1];
        long[] dp = new long[n+1];

        long max = 0 ;
        for(int i = 1; i <= n ; i ++){
            num[i] = Integer.parseInt(strArr[i-1]);
            int target = 0;
            for(int j = i-1; j>0; j--){
                if(num[i]>num[j]){
                    if(num[target] < num[j] && dp[target] < dp[j]){
                        target = j;
                    }
                }
            }
            dp[i] = dp[target] + 1;
            if(dp[i] > max){
                max = dp[i];
            }
        }
        System.out.println(max);
        StringBuilder sb = new StringBuilder();
        int beforeIdx = -1;
        Stack<Long> stack = new Stack<>();
        for(int i = n ; i >0; i --){
            if(dp[i] == max){
                if(beforeIdx != -1 && num[beforeIdx] <= num[i]){
                    continue;
                }
                stack.push(num[i]);
                max --;
                beforeIdx = i;
            }
        }

        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
