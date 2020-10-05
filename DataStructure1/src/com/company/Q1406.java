package com.company;

import java.io.*;
import java.util.Stack;

public class Q1406 {
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
        String str = br.readLine();
        int cnt = Integer.parseInt(br.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i = 0 ; i < str.length(); i ++){
            leftStack.push(str.charAt(i));
        }

        for(int i =0 ; i < cnt ; i ++){
            String[] tmpArr = br.readLine().split(" ");
            switch(tmpArr[0]){
                case "L":
                    if(!leftStack.empty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.empty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if(!leftStack.empty()){
                        leftStack.pop();
                    }
                    break;
                case "P":
                    leftStack.push(tmpArr[1].charAt(0));
                    break;
            }
        }
        while(!leftStack.empty()){
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!rightStack.empty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
