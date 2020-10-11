package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1918 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String str = bf.readLine();
        Stack<Character> oper = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i <str.length(); i++){
            char ch = str.charAt(i);
            switch(ch){
                case '(':
                    oper.push(ch);
                    break;
                case '*':
                case '/':
                    if(!oper.empty()){
                        if(oper.peek() == '*' || oper.peek() == '/'){
                            sb.append(oper.pop());
                        }
                    }
                    oper.push(ch);
                    break;
                case '+':
                case '-':
                    if(!oper.empty()){
                        if (oper.peek() == '*' || oper.peek() == '/') {
                            while(!oper.empty()){
                                if(oper.peek()!='('){
                                    sb.append(oper.pop());
                                    continue;
                                }
                                break;
                            }
                        }
                        else if(oper.peek() == '-' || oper.peek()=='+'){
                            sb.append(oper.pop());
                        }
                    }
                    oper.push(ch);
                    break;
                case ')':
                    while(!oper.empty()){
                        if(oper.peek()!='('){
                            sb.append(oper.pop());
                            continue;
                        }
                        break;
                    }
                    if(!oper.empty()&&oper.peek()=='(')oper.pop();
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }
        while(!oper.empty()){
            sb.append(oper.pop());
        }
        System.out.println(sb);
    }
}
