package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Q9093 {
    public static void main(String[] args) throws Exception {
//        BufferedReader sc = new BufferedReader(new FileReader(new File("data.txt")));
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(sc.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < T ; i ++) {
            String[] strArr = sc.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {

                for (int j = 0; j < str.length(); j++) {
                    stack.push(str.charAt(j));
                }
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }
}
