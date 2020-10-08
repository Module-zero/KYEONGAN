package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q10866 {
    public static int[] deque = new int[10001];
    public static int front = 0;
    public static int rear = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < n ; i ++){
            String[] command = bf.readLine().split(" ");
            switch(command[0]){
                case "push_front":
                    push_front(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(command[1]));
                    break;
                case "empty":
                    if(empty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "pop_front":
                    pop_front();
                    break;
                case "pop_back":
                    pop_back();
                    break;
                case "size":
                    size();
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

    public static void push_front(int n ){
        if(front == 0){
            if(rear !=0 ){
                int[] clone = deque.clone();
                for(int i = 1 ; i < clone.length ; i++){
                    deque[i] = clone[i-1];
                }
            }
            deque[front] = n;
            rear++;
            return;
        }
        deque[--front]=n;
    }
    public static void push_back(int n){
        deque[rear++] = n;
    }

    public static boolean empty(){
        if(front == rear){
            return true;
        }
        return false;
    }

    public static void pop_front(){
        if(empty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque[front++]);
    }
    public static void pop_back(){
        if(empty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque[--rear]);
    }

    public static void size(){
        System.out.println(rear-front);
    }

    public static void front(){
        if(empty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque[front]);
    }

    public static void back(){
        if(empty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque[rear-1]);
    }
}
