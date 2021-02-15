import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q1786 {
    static char[] T;
    static char[] P;
    static int[] fail;
    static StringBuilder sb;
    static int n ;
    static int m;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = bf.readLine().toCharArray();
        P = bf.readLine().toCharArray();
        n = P.length;
        m = T.length;
        fail = new int[n];
        failFunction();
    }
    public static void failFunction(){
        for(int i = 1 ; i < n ; i ++){
            int t = fail[i-1];
            while(t > 0 && P[t] != P[i]) {
                t--;
            }
            if(P[t] == P[i]) {
                fail[i] = t+1;
            }
        }
    }
}
