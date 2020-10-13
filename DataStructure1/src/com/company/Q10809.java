package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q10809 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        char[] chArr = bf.readLine().toCharArray();
        HashMap<Character,Integer> counter = new HashMap<>();
        for(int i = 0 ; i < chArr.length; i++){
            char ch = chArr[i];
            if(counter.get(ch) == null) {
                counter.put(ch,i);
            }
        }
        for(int i = 'a' ; i <= 'z' ; i ++){
            if(counter.get((char)i) == null){
                System.out.print(-1+" ");
                continue;
            }
            System.out.print(counter.get((char)i)+" ");
        }
    }
}
