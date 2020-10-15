package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11656 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        StringBuilder str = new StringBuilder();
        str.append(bf.readLine());
        String[] strArr = new String[str.length()];

        strArr[0] = str.toString();
        for( int i = 1 ; i < strArr.length; i++){
            strArr[i] = str.deleteCharAt(0).toString();
        }
        quickSort(strArr,0, strArr.length-1);
        for(String tmp : strArr){
            System.out.println(tmp);
        }

    }
    public static void quickSort(String[] strArr, int start, int end){
        if(start >= end){
            return;
        }
        int pivotIdx = start;
        String pivot = strArr[pivotIdx];
        int i = start;
        int j = end;
        while(true){
            while(strArr[++i].compareTo(pivot) < 0 && i < end);
            while(strArr[j].compareTo(pivot) > 0 && j > 0 ) j--;
            if(i >= j){
                String tmp = strArr[j];
                strArr[j] = pivot;
                strArr[pivotIdx] = tmp;
                pivotIdx = j;
                break;
            }
            String tmp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = tmp;
        }
        quickSort(strArr,start,pivotIdx-1);
        quickSort(strArr,pivotIdx+1,end);
    }
}
