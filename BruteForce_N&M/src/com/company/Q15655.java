package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q15655 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args )throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        sb = new StringBuilder();
        String[] strArr1 = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr1[0]);
        int m = Integer.parseInt(strArr1[1]);
        String[] strArr2 = bf.readLine().split(" ");
        int[] numArr = new int[n];
        int[] answer = new int[m];
        for(int i = 0 ; i < n ;i++ ){
            numArr[i] = Integer.parseInt(strArr2[i]);
        }
        quickSort(numArr,0,n);
        select(answer,numArr,n,m,0,0);
        System.out.println(sb);
    }
    public static void select(int[] answer, int[] numArr, int n, int m, int cnt,int start){
        if(m == cnt) {
            for (int num : answer) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n ; i ++){
            answer[cnt] = numArr[i];
            select(answer,numArr,n,m,cnt+1,i+1);
        }
    }
    public static void quickSort(int[] numArr,int start,int end){
        if(start>=end){
            return;
        }
        int pivotIdx = start;
        int pivot = numArr[pivotIdx];
        int i = start;
        int j = end;
        while(true){
            while(++i < end && numArr[i] < pivot);
            while(--j > start && numArr[j] > pivot);
            if(i >= j){
                int tmp = pivot;
                numArr[pivotIdx] = numArr[j];
                numArr[j] = pivot;
                pivotIdx = j;
                break;
            }
            int tt = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = tt;
        }
        quickSort(numArr,start,pivotIdx);
        quickSort(numArr,pivotIdx+1,end);
    }
}
