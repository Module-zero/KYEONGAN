package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q11021 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        int T = Integer.parseInt(sc.nextLine());
        for( int i = 0 ; i < T ; i ++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println("Case #"+(i+1)+": "+(A+B));
        }
    }
}
