import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1561 {
    static long[] rides;
    static long n;
    static long m;
    public static void main(String[] args)throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] init = bf.readLine().split(" ");
        n = Long.parseLong(init[0]);
        m = Long.parseLong(init[1]);
        rides = new long[(int)m];
        String[] str = bf.readLine().split(" ");
        for(int i = 0 ; i < m ; i ++){
            rides[i] = Long.parseLong(str[i]);
        }
        if(n <= m){
            System.out.println(n);
            return;
        }
        long left = 0;
        long right = 2000000000L * 30L;
        long minute = 0;
        while(left <= right){
            long mid = (left+right)/2;
            if(go(mid)){
                right = mid - 1;
                minute = mid;
            }
            else{
                left = mid + 1;
            }
        }

        long begin = m ;
        for(int i = 0 ; i < m ; i ++){
            begin += (minute - 1)/rides[i];
        }
        for( int i = 0 ; i < m ; i ++){
            if(minute%rides[i] == 0){
                begin++;
            }
            if(begin == n){
                System.out.println(i+1);
                return;
            }
        }

    }
    public static boolean go(long mid){
        long answer  = m;
        for(int i = 0 ; i < m ; i ++){
            answer += mid/rides[i];
        }
        if(answer >= n){
            return true;
        }
        else{
            return false;
        }

    }
}

