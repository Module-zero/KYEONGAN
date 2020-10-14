package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1107 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int answer = 500001;
        int channel = Integer.parseInt(bf.readLine());
        int checkNum = Integer.parseInt(bf.readLine());
        boolean[] buttonCheck = new boolean[10];
        String[] strArr;
        if( checkNum != 0) {
            strArr = bf.readLine().split(" ");
            for (String str : strArr) {
                buttonCheck[Integer.parseInt(str)] = true;// 고장남 = true
            }
        }
        int minus = channel;
        int plus = channel;
        int current = 100;
        boolean pFlag = confirmChannel(buttonCheck,plus);
        boolean mFlag = pFlag;
        if(checkNum != 10) {
            while(!pFlag  && !mFlag){
                plus ++;
                minus --;
                if(minus < 0){
                    minus = 0;
                }
                pFlag = confirmChannel(buttonCheck,plus);
                mFlag = confirmChannel(buttonCheck,minus);
            }
            if(mFlag && pFlag){
                int pLen = (plus+"").length();
                int mLen = (minus+"").length();
                if( pLen > mLen){
                    answer = mLen ;
                    answer += absol(minus, channel );
                }
                else{
                    answer = pLen;
                    answer += absol(plus, channel);
                }
            }
            else if(mFlag){
                int mLen = (minus+"").length();
                answer = mLen ;
                answer += absol(minus, channel );
            }
            else{
                int pLen = (plus+"").length();
                answer = pLen;
                answer += absol(plus, channel);
            }
        }
        int currentChannel = absol(current,channel);
        answer = answer > currentChannel ? currentChannel : answer;
        System.out.println(answer);
    }
    public static int absol(int a, int b){
        return a > b? a -b : b - a;
    }
    public static boolean confirmChannel(boolean[] buttonCheck, int num){
        if(num == 0){
            return !buttonCheck[0];
        }
        while(num!=0){
            int r = num % 10;
            num /= 10;
            if(buttonCheck[r]){
                return false;
            }
        }
        return true;
    }
}
