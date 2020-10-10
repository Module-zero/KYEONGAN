package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1935 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());

        String strArr = bf.readLine();

        double[] num = new double[n];
        for(int i = 0; i < n; i ++){
            int tmp = Integer.parseInt(bf.readLine());
            num[i] = tmp;
        }
        Stack<Double> number = new Stack<>();
        for(int i = 0 ; i < strArr.length() ; i ++){
            char str = strArr.charAt(i);
            switch(str){
                case '+':
                    number.push(number.pop() + number.pop());
                    break;
                case '-':
                    double tmp = number.pop();
                    number.push(number.pop() - tmp);
                    break;
                case '*':
                    number.push(number.pop() * number.pop());
                    break;
                case '/':
                    double tmp2 = number.pop();
                    number.push(number.pop() / tmp2);
                    break;
                default:
                    number.push(num[str-65]);
                    break;

            }
        }
        System.out.printf("%.2f",number.pop());
    }
}
