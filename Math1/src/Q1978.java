package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1978 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");

        boolean[] arr = prime();
        int answer = 0;
        for(int i = 0 ; i < t ; i ++){
            int tmp = Integer.parseInt(str[i]);
            if(arr[tmp] == false){
                answer ++;
            }
        }
        System.out.println(answer);
    }

    public static boolean[] prime(){
        boolean[] arr = new boolean[1001];
        arr[1] = true;
        for(int i = 2 ; i <= 100 ; i ++){
            if(arr[i]== false){
                for(int j = i + i ; j <= 1000 ; j+=i){
                    arr[j]=true;
                }
            }
        }
        return arr;
    }

}
