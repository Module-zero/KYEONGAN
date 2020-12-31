import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1783 {
    static int N;
    static int M;
    static int[][] move = {{2,1},{1,2},{-2,1},{-1,2}};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        if( N == 1){
            System.out.println(1);
        }
        else if(N ==2){
            if(M <= 6){
                System.out.println((M/2)+(M%2));
            }
            else{
                System.out.println(4);
            }
        }
        else{
            if( 1<= M&& M < 5 ){
                System.out.println(M);
            }
            else if( 5 <= M && M < 7){
                System.out.println(4);
            }
            else{
                System.out.println(M-2);
            }
        }
    }
}
