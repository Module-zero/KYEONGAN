package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q6588 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = prime();
        while(true){
            boolean gold = false;
            int tmp = Integer.parseInt(bf.readLine());
            if(tmp == 0 ){
                break;
            }
            for(int i = 3 ; i <= tmp ; i+=2){
                if(!arr[i] && !arr[tmp-i]){
                    gold = true;
                    sb.append(tmp+" = "+i+" + "+(tmp-i)+"\n");
                    break;
                }
            }
            if(!gold){
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean[] prime(){
        int size = 1000001;
        boolean[] arr = new boolean[size];
        arr[0] = true;
        arr[1] = true;
        for(int i = 2 ; i < size ; i ++){
            if(!arr[i]){
                for(int j = i*2 ; j < size ; j += i){
                    arr[j] = true;
                }
            }
        }
        return arr;
    }
}
