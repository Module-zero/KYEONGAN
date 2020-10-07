package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11653 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        boolean[] arr = prime();
        StringBuilder sb = new StringBuilder();
        if(n == 1){
            sb.append(1);
        }
        for(int i = 2 ; i <= n ; i ++){
            if(n == 0){
                break;
            }
            if(arr[i] == false){
                while(n != 0){
                    int r = n % i;
                    if(r != 0 ){
                        break;
                    }
                    n/=i;
                    sb.append(i).append("\n");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    public static boolean[] prime(){
        boolean[] arr = new boolean[10000001];
        arr[1] = true;
        for(int i = 2 ; i < 10000000 ; i ++){
            if(arr[i] == false){
                for(int j = i+i ; j < 10000000 ; j+=i){
                    arr[j] = true;
                }
            }
        }
        return arr;
    }
}
