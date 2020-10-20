import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1149 {
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        long[][] house = new long[n+1][3]; // 0:R, 1:G, 2:B
        for(int i = 1 ; i <= n ; i ++){
            String[] str = bf.readLine().split(" ");
            house[i][0] = Integer.parseInt(str[0]);
            house[i][1] = Integer.parseInt(str[1]);
            house[i][2] = Integer.parseInt(str[2]);
        }
        long[][] dp = new long[n+1][3];
        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];
        for(int i = 2 ; i <= n; i ++){
            dp[i][0] = ( dp[i-1][1] > dp[i-1][2] ? dp[i-1][2] : dp[i-1][1] )+ house[i][0];
            dp[i][1] = ( dp[i-1][0] > dp[i-1][2] ? dp[i-1][2] : dp[i-1][0] )+ house[i][1];
            dp[i][2] = ( dp[i-1][0] > dp[i-1][1] ? dp[i-1][1] : dp[i-1][0] )+ house[i][2];
        }
        long min = dp[n][1] > dp[n][0] ? dp[n][0] : dp[n][1];
        min = dp[n][2] > min ? min : dp[n][2];
        System.out.println(min);
    }
}
