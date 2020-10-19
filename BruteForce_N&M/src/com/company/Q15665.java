package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q15665 {
    static Set<String> list = new LinkedHashSet<>();
    static int n ;
    static int m ;
    static int[] numArr;
    static int[] answer ;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        answer = new int[m];
        numArr= new int[n];
        String[] strArr1 = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr1[i]);
        }
        Arrays.sort(numArr);
        select(0);
        for(String str : list){
            sb.append(str+"\n");
        }
        System.out.println(sb);
    }
    public static void select(int cnt){
        if(cnt == m){
            String str = "";
            for(int num : answer){
                str+=num+" ";
            }
            list.add(str);
            return;
        }
        for(int i = 0; i < n ; i ++){
            answer[cnt] = numArr[i];
            select(cnt+1);
        }
    }
}
