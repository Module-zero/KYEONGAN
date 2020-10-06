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
        m = m>n-m? n-m : m;
        long nCnt5 = count((n-m)+1,n,5);
        long nCnt2 = count((n-m)+1,n,2);

        long nCnt = nCnt2 > nCnt5 ? nCnt5 : nCnt2;

        int mCnt = count(1,m,5);

        System.out.println(nCnt - mCnt);
    }
    public static int count(long start, long end,int x){
        int answer = 0;
        for( long i = start ; i <= end ; i++){
            long j = i;
            while(j>0){
                if(j%x == 0){
                    answer++;
                    j=j/x;
                    continue;
                }
                break;
            }
        }
        return answer;
    }
}
