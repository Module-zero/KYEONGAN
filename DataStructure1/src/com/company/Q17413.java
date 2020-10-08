package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413 {
    public static void main(String[] args )throws Exception{
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        char[] charLine = bf.readLine().toCharArray();
        Stack<Character> reverseStack = new Stack<>();
        boolean reverse = true;
        StringBuilder sb = new StringBuilder();
        for(char str : charLine){
            if(str == '<' || str == '>'|| !reverse){
                while(!reverseStack.empty()){
                    sb.append(reverseStack.pop());
                }
                reverse = false;
                sb.append(str);
                if(str=='>'){
                    reverse=true;
                }
            }
            else if(str == ' ' || str == '\n'){
                while(!reverseStack.empty()){
                    sb.append(reverseStack.pop());
                }
                sb.append(' ');

            }
            else{
                reverseStack.push(str);
            }
        }
        while(!reverseStack.empty()){
            sb.append(reverseStack.pop());
        }
        System.out.println(sb);
    }
}
