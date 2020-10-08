package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q10845 {
    public static int[] queue = new int[10001];
    static int front = 0;
    static int rear = 0;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < n ; i ++){
            String[] command = bf.readLine().split(" ");
            switch(command[0]){
                case "push":
                    push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    if(empty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
                default:
                    ;
            }
        }
    }

    public static void push(int n){
        queue[rear++] = n;
    }

    public static boolean empty(){
        if(front == rear){
            return true;
        }
        return false;
    }

    public static void pop(){
        System.out.println(empty()?-1:queue[front++]);
    }

    public static void size(){
        System.out.println(rear-front);
    }

    public static void front(){
        System.out.println(empty()?-1:queue[front]);
    }

    public static void back(){
        System.out.println(empty()?-1:queue[rear-1]);
    }
}
