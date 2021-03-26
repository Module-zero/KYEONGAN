import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2632 {
    static int N;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        String[] init = bf.readLine().split(" ");
        int a = Integer.parseInt(init[0]);
        int b = Integer.parseInt(init[1]);
        int[] pizzaA = new int[a];
        int[] pizzaB = new int[b];
        int[] sumA = new int[N+1];
        int[] sumB = new int[N+1];
        insert(bf,pizzaA, sumA);
        insert(bf,pizzaB, sumB);
        long answer = 0;
        for(int i = 0 ; i <= N ; i ++){
            answer += (sumA[i]*sumB[N-i]);
        }
        System.out.println(answer);
    }

    private static void insert(BufferedReader bf, int[] pizza, int[] sumArr) throws IOException {
        sumArr[0] = 1;
        int max = pizza.length;
        int total = 0;
        for(int i = 0 ; i < max ; i ++){
            pizza[i] = Integer.parseInt(bf.readLine());
            total += pizza[i];
        }
        for(int i = 0 ; i < max ; i ++){
            int idx = i;
            int sum = 0;
            for(int j = 0 ; j < max-1 ; j ++){
                sum += pizza[idx];
                if(sum > N)break;
                sumArr[sum]++;
                idx++;
                idx = idx%max;
            }
        }
        if(total <= N) {
            sumArr[total]++;
        }
    }
    public static void print(int[] ss){
        for(int s : ss){
            System.out.print(s+" ");
        }
        System.out.println(" ");
    }
}
