package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1212 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        char[] numArr = bf.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char numChar : numArr){
            int num = Integer.parseInt(numChar+"");
            for(int i = 0 ; i < 3 ; i++){
                if(num != 0) {
                    stack.push(num % 2);
                }
                else{
                    stack.push(0);
                }
                num /= 2;
            }
            while(!stack.empty()){
                sb.append(stack.pop());
            }
        }

        while(sb.charAt(0) == '0'&&sb.length()!= 1){
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}
