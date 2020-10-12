package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q10808 {
    public static void main(String[]args )throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        char[] chArr = bf.readLine().toCharArray();
        HashMap<Character,Integer> counter = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 97 ; i <= 122; i ++ ){
            char ch = (char)i;
            counter.put(ch,0);
        }
        for(char ch : chArr){
            counter.put(ch,counter.get(ch)+1);
        }
        for(int i = 97 ; i <= 122 ; i ++){
            sb.append(counter.get((char)i)+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
