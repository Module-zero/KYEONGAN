package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Q2309 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int[] height = new int[9];
        for(int i = 0 ; i < 9 ; i ++){
            height[i] = Integer.parseInt(bf.readLine());
        }
        quickSort(height,0,8);
        for(int i =0 ; i < 9 ; i ++){
            for(int j = 0 ; j < 9 ; j++){
                if(i == j){
                    continue;
                }
                int sum = 0;
                for(int num : height) {
                    if(num != height[i] && num != height[j]) {
                        sum += num;
                    }
                }
                if(sum == 100){
                    height[i] = -1;
                    height[j] = -1;
                    for(int num : height){
                        if(num != -1) {
                            System.out.println(num);
                        }
                    }
                    return;
                }
            }
        }
    }
    public static void quickSort(int[] arr, int start,int end){
        if(start >= end){
            return;
        }
        int pivotIdx = start;
        int pivot = arr[pivotIdx];
        int i = start;
        int j = end;
        while(true) {
            while (arr[++i] < pivot && i < end) ;
            while (arr[j] > pivot && j > 0) j--;
            if( i >= j){
                int tmp = arr[j];
                arr[j] = pivot;
                arr[pivotIdx] = tmp;
                pivotIdx = j;
                break;
            }
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        quickSort(arr,start,pivotIdx-1);
       quickSort(arr,pivotIdx+1,end);
    }

}
