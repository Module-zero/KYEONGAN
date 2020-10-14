package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1476 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int e = Integer.parseInt(strArr[0]);
        int s = Integer.parseInt(strArr[1]);
        int m = Integer.parseInt(strArr[2]);

        int eNum = 1;
        int sNum = 1;
        int mNum = 1;

        int answer = 1;
        while(eNum != e || sNum != s || mNum!= m){
            eNum = ++eNum <= 15 ? eNum : 1;
            sNum = ++sNum <= 28 ? sNum : 1;
            mNum = ++mNum <= 19 ? mNum : 1;
            ++answer;
        }
        System.out.println(answer);
    }
}
