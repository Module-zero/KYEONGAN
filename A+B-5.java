package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A+B-5.java {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
		int T = sc.nextInt();
		for( int i = 0 ; i < T ; i ++){
            int A = sc.nextInt();
			sc.next();
            int B = sc.nextInt();
            System.out.println(A+B);
        }
    }
}
