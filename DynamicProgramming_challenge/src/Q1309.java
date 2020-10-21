import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Q1309 {
    static int[][] dp ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        dp = new int[n+1][3];
        int i = 1 ;
        dp[i][0] = 1;
        dp[i][1] = 1;
        dp[i][2] = 1;
        i++;
        while(i <= n){
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][0])%9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
            i++;
        }
        System.out.println((dp[n][0]+ dp[n][1]+ dp[n][2])%9901);
    }
}
