package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q6064 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < t ; i ++){
            boolean endFlag = false;
            int cnt = 1;
            String[] strArr= bf.readLine().split(" ");
            int m = Integer.parseInt(strArr[0]);
            int n = Integer.parseInt(strArr[1]);
            int x = Integer.parseInt(strArr[2]);
            int y = Integer.parseInt(strArr[3]);
            int ip = 1;
            int jp = 1;
            while(ip!=x){
               ++ip;
               ++jp;
               ++cnt;
               if(ip == x && jp == y)endFlag = true;
            }
            int lcm = lcm(m,n);
            while(jp > n)jp-=n;
            if(ip == x && jp == y)endFlag = true;
            while(jp!=y){
                jp = jp+m;
                while(jp > n)jp-=n;
                cnt+=m;
                if(cnt > lcm){
                    break;
                }
                if(ip == x && jp == y)endFlag = true;
            }

            if(endFlag){
                sb.append(cnt+"\n");
                continue;
            }
            sb.append(-1+"\n");
        }
        System.out.println(sb);
    }
    public static int lcm(int a,int b){
        int gcd ;
        int anum  = a;
        int bnum = b;
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        gcd = a;
        return (anum*bnum)/gcd;
    }
}
