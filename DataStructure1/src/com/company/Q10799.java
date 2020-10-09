package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799 {
    public static void main(String[] args )throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        char[] charArr = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        boolean stick = false;

        int answer = 0;
        int cnt = 0;
        for(char str : charArr){
            if(str == '('){
                cnt ++;
                stick = true;
                continue;
            }
            else{
                if(stick){
                    stick = false;
                    cnt --;
                    answer += cnt;
                    continue;
                }
                cnt--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
