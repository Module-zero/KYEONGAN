package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1934 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < t ; i ++){
            String[] str = bf.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int gcd = GCD(x,y);
            sb.append(x*y/gcd).append("\n");
        }
        System.out.println(sb);
    }
    public static int GCD(int x, int y){
        while(y != 0){
            int r = x%y;
            x = y;
            y = r;
        }
        return x;
    }
}
