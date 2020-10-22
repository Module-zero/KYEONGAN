import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2156 {
    static int[] drink;
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        drink = new int[n+1];
        for(int i = 1 ; i <= n ; i ++){
            drink[i] = Integer.parseInt(bf.readLine());
        }
        int[][] dp = new int[n+1][3];
        dp[1][2] = drink[1]; // 연속두잔
        dp[1][1] = drink[1]; // 연속한잔
        dp[1][0] = 0;        // 안마심

        for(int i = 2; i <= n ; i ++){
            dp[i][2] = Math.max(dp[i-1][1] + drink[i],dp[i-1][0] + drink[i]);
            dp[i][1] = dp[i-1][0] + drink[i];
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][0] = Math.max(dp[i][0],dp[i-1][2]);
        }
        int answer = Math.max(dp[n][0],dp[n][1]);
        System.out.println(Math.max(answer,dp[n][2]));
    }
}
