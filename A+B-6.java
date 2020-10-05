package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
		int T = Integer.parseInt(sc.nextLine());
		for( int i = 0 ; i < T ; i ++){
            String str = sc.nextLine();
            String[] strArr = str.split(",");
            int A = Integer.parseInt(strArr[0]);
            int B = Integer.parseInt(strArr[1]);
            System.out.println(A+B);
        }
    }
}
