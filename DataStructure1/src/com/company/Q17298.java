package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] strArr = bf.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int[] NGE = new int[n];
        for(int i = 0 ; i < n-1 ; i ++){
            int target = Integer.parseInt(strArr[i]);
            stack.push(i);
            int num = -1;
            int tmp = Integer.parseInt(strArr[i+1]);
            if(target < tmp){
                num = tmp;
                stack.pop();
                while(!stack.empty()){
                    int stackNum = Integer.parseInt(strArr[stack.peek()]);
                    if(stackNum >= num){
                        break;
                    }
                    NGE[stack.pop()] = num;
                }
            }
            NGE[i] = num;
        }
        NGE[n-1] = -1;
        StringBuilder sb = new StringBuilder();
        for(int out : NGE){
            sb.append(out+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
