package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q11005 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        long n = Long.parseLong(strArr[0]);
        long b = Long.parseLong(strArr[1]);

        convert(n,b);
    }

    public static String convert(long n,long b){
        b -=1;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(n != 0){
            System.out.println(n+":"+b);
            long r = n%b;
            System.out.println(90-r);
            n/=b;
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
        return sb.toString();
    }

}
