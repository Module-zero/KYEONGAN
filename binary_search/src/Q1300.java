import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Q1300 {
    static long n;
    static long k;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());

        long left = 1;
        long right = n*n;
        long answer = right;
        while(left <= right){
            long mid = (left+right)/2;
            if(go(mid)){
                right = mid - 1;
                answer = Math.min(answer,mid);
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean go(long mid){
        long ans = 0;
        for(int i = 1 ; i <= n ; i ++){
            ans += Math.min(n,mid/i);
        }
        if(ans >= k){
            return true;
        }
        return false;
    }
}
