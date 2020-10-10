package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17299 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());


        String[] strArr = bf.readLine().split(" ");
        int[] NGF = new int[1000001];

        int[] F = new int[1000001];

        for(String str : strArr){
            int num = Integer.parseInt(str);
            F[num] ++;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n-1 ; i++){
            int targetNum = Integer.parseInt(strArr[i]);
            int targetF = F[targetNum];
            int compNum = Integer.parseInt(strArr[i+1]);
            int compF = F[compNum];
            if(targetF >= compF){
                stack.push(i);
                NGF[i] = -1;
                continue;
            }
            NGF[i] = compNum;
            while(!stack.empty()){
                int stackIdx = stack.peek();
                int stackNum = Integer.parseInt(strArr[stackIdx]);
                int stackF = F[stackNum];
                if(stackF >= compF){
                    break;
                }
                NGF[stack.pop()] = compNum;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n-1 ; i ++){
            sb.append(NGF[i]+" ");
        }
        sb.append(-1);
        System.out.println(sb);


    }
}
