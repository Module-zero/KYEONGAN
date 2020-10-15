package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11655 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String str = bf.readLine();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < str.length(); i ++){
            char ch = str.charAt(i);
            if('a' <= ch && ch <= 'z'){
                ch = (ch + 13) > 'z' ? (char)('a'+ (13 - ('z' - ch))-1) : (char)(ch + 13);
            }
            else if('A' <= ch && ch <= 'Z'){
                ch = (ch + 13) > 'Z' ? (char)('A'+(13 - ('Z' - ch))-1) : (char)(ch + 13);
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
