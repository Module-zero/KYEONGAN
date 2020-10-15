package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10820 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str = bf.readLine()) != null){
            int lower = 0;
            int upper = 0;
            int number = 0;
            int space = 0;
            for(int i = 0 ; i < str.length() ; i ++){
                char ch = str.charAt(i);
                if('a'<= ch && ch <='z'){
                    lower ++;
                }
                else if('A' <= ch && ch <= 'Z'){
                    upper ++;
                }
                else if('0' <= ch && ch <= '9'){
                    number ++;
                }else{
                    space ++;
                }
            }
            sb.append(lower+" "+upper+" "+number+" "+space+"\n");
        }
        System.out.println(sb);
    }
}
