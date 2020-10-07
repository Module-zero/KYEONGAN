package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2089 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        long n = Integer.parseInt(bf.readLine());
        int plusFlag = 1;
        if( n < 0 ){
            n *= -1;
            plusFlag = -1;
        }
        StringBuilder sb = new StringBuilder();
        if(n == 0 )sb.append(0);
        while(n != 0){
            long r = n%2;
            sb.append(r);
            if(plusFlag == -1 && n%2 != 0){
                ++n;
            }
            n/=2;
            plusFlag*=-1;
        }

        System.out.println(sb.reverse());
        //
    }
}
