import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16938 {
    static int n;
    static int l;
    static int r;
    static int x;
    static int[] problems;
    static int answer = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        l = Integer.parseInt(str[1]);
        r = Integer.parseInt(str[2]);
        x = Integer.parseInt(str[3]);
        problems = new int[n];
        String[] pStr = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            problems[i] = Integer.parseInt(pStr[i]);
        }
        select(0,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println(answer);
    }
    public static void select(int idx, int select,int sum,int max,int min){
        if(idx >= n){
            if(select >= 2){
                if(l <= sum && sum <= r){
                    if(max - min >= x){
                        answer++;
                    }
                }
            }
            return;
        }
        select(idx+1,select+1,sum+problems[idx],Math.max(max,problems[idx]),Math.min(min,problems[idx]));
        select(idx+1,select,sum,max,min);
    }
}
