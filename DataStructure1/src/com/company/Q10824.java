package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10824 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        System.out.println(Long.parseLong(str[0]+str[1])+Long.parseLong(str[2]+str[3]));
    }
}
