package com.company;

import java.io.*;
import java.util.Scanner;

public class Q10828 {
    public static void main(String[] args) throws IOException {
        MyStack stack = new MyStack();
        BufferedReader sc = new BufferedReader(new FileReader("data.txt"));
        int N = Integer.parseInt(sc.readLine());
        for(int i = 0; i < N ; i++){
            String[] strArr = sc.readLine().split(" ");
            switch(strArr[0]){
                case "push":
                    stack.push(Integer.parseInt(strArr[1]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }
        }
    }
    public static class MyStack{
        private int size;
        private int[] arr ;
        public MyStack(){
            size = 0;
            arr = new int[10000];
        }
        public void push(int x){
            arr[size++] = x;
        }
        public void pop(){
            int returnNum;
            if(size == 0){
                returnNum = -1;
            }
            else{
                returnNum = arr[--size];
            }
            System.out.println(returnNum);
        }
        public void size(){
            System.out.println(size);
        }
        public void empty(){
            int returnNum;
            if(size == 0){
                returnNum = 1;
            }
            else {
                returnNum = 0;
            }
            System.out.println(returnNum);
        }
        public void top() {
            int returnNum;
            if(size == 0 ){
                returnNum = -1;
            }
            else {
                returnNum = arr[size - 1];
            }
            System.out.println(returnNum);
        }
    }
}
