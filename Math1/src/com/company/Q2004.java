package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2004 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        long n = Long.parseLong(str[0]);
        long m = Long.parseLong(str[1]);

        long nCnt5 = count(n,5);
        long nCnt2 = count(n,2);

        long mCnt5 = count(m,5);
        long mCnt2 = count(m,2);

        long nmCnt5 = count(n-m,5);
        long nmCnt2 = count(n-m,2);

        long cnt2 = nCnt2 - (mCnt2+nmCnt2);
        long cnt5 = nCnt5 - (mCnt5+nmCnt5);

        long answer = cnt2 > cnt5 ? cnt5 : cnt2;
        System.out.println(answer);
    }
    public static int count( long end,int x){
        int answer = 0;
        for( long i = x ; i <= end ; i*=x){
            answer += end/i;
        }
        return answer;
    }

}
