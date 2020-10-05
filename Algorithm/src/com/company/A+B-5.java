package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        while(true){
            int A = sc.nextInt();
            int B = sc.nextInt();
            if(A==0&&B==0){
                break;
            }
            System.out.println(A+B);
        }
    }
}
