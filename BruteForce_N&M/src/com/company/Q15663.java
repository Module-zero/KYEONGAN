package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q15663 {
    static StringBuilder sb = new StringBuilder();
    static Set<String> arrayList = new LinkedHashSet<>();
    public static void main(String[] args )throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        sb = new StringBuilder();
        String[] strArr1 = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr1[0]);
        int m = Integer.parseInt(strArr1[1]);
        String[] Arr2 = bf.readLine().split(" ");
        int[] strArr2 = new int[n];
        for(int i = 0 ; i < n ; i ++){
            strArr2[i] = Integer.parseInt(Arr2[i]);
        }
        Arrays.sort(strArr2);
        int[] answer = new int[m];
        boolean[] check = new boolean[n];
        select(answer, strArr2, n , m ,0,check);
        for(String str : arrayList){
            sb.append(str);
        }
        System.out.print(sb);
    }
    public static void select(int[] answer, int[] strArr, int n, int m, int cnt,boolean[] check){
        if(m <= cnt){
            StringBuilder ss = new StringBuilder();
            for(int str : answer){
                ss.append(str+" ");
            }
            arrayList.add(ss.toString()+"\n");
            return;
        }
        for(int i = 0 ; i < n; i ++){
            if(!check[i]){
                check[i] = true;
                answer[cnt] = strArr[i];
                select(answer,strArr,n,m,cnt+1,check);
                check[i] = false;
            }
        }
    }
    public static void quickSort(String[] numArr,int start,int end){
        if(start>=end){
            return;
        }
        int pivotIdx = start;
        String pivot = numArr[pivotIdx];
        int i = start;
        int j = end;
        while(true){
            while(++i < end && numArr[i].compareTo(pivot) < 0);
            while(--j > start && numArr[j].compareTo(pivot) > 0);
            if(i >= j){
                String tmp = pivot;
                numArr[pivotIdx] = numArr[j];
                numArr[j] = pivot;
                pivotIdx = j;
                break;
            }
            String tt = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = tt;
        }
        quickSort(numArr,start,pivotIdx);
        quickSort(numArr,pivotIdx+1,end);
    }
}

