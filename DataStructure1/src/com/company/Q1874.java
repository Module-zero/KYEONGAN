package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean[] beforeUse = new boolean[n+1];
        stack.push(0);
        for(int i = 0 ; i < n ; i ++){
            int num = Integer.parseInt(bf.readLine());
            if(!stack.empty() && stack.peek() > num){
                while(stack.peek()!=num) {
                    beforeUse[stack.pop()] = true;
                    sb.append("-\n");
                }
            }
            else{
                int startNum = stack.peek()+1;
                for(int j = startNum ; j <= num ; j ++){
                    if(!beforeUse[j]) {
                        stack.push(j);
                        sb.append("+\n");
                    }
                }
            }
            if(beforeUse[stack.peek()] || stack.peek() != num){
                System.out.println("NO");
                return ;
            }
            beforeUse[stack.pop()] = true;
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
