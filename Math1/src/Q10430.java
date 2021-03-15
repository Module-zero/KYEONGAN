package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q10430 {

    public static void main(String[] args)throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));

        String[] arr = br.readLine().split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int C = Integer.parseInt(arr[2]);

        StringBuffer sb = new StringBuffer();
        sb.append((A+B)%C).append("\n");
        sb.append(((A%C)+(B%C))%C).append("\n");
        sb.append((A*B)%C).append("\n");
        sb.append(((A%C)*(B%C))%C).append("\n");
        System.out.println(sb);
    }
}
