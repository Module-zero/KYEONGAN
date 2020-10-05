package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());



        for(int i = 0 ; i < T ; i ++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean VPS = true;

            for(int k = 0 ; k < str.length(); k++) {
                if (str.charAt(k) == '(') {
                    stack.push(str.charAt(k));
                } else {
                    if (stack.empty()) {
                        VPS = false;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(VPS == true && stack.empty()) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
