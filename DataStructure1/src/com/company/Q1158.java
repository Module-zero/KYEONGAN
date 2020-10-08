package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1158 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        boolean[] arr = new boolean[5001];
        arr[0] = true;
        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);

        int delete = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 1 ; i <= n ; i ++){
            do{
                delete = (delete+1) > n ? 0 : delete+1;
                if(!arr[delete]){
                    cnt++;
                }
            }while(cnt != k);
            cnt = 0;
            arr[delete] = true;
            sb.append(delete+", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
