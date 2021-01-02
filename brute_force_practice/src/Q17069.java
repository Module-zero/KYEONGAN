import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q17069 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 1 ; j <= n ; j ++){
                map[i][j] = Integer.parseInt(tmp[j-1]);
            }
        }
        if(map[n][n] == 1){
            System.out.println(0);
            return;
        }
        long[][][] dp = new long[n+1][n+1][3]; // 0:가로, 1:세로, 2:대각선
        dp[1][2][0] = 1;
        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <=n ; j ++){
                if(( i == 1 && j == 2 ) || map[i][j] == 1) {
                    continue;
                }
                dp[i][j][0] = (dp[i][j - 1][0] + dp[i][j - 1][2]);
                dp[i][j][1] = (dp[i - 1][j][1] + dp[i - 1][j][2]);
                dp[i][j][2] = (dp[i - 1][j - 1][2] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][0]);
                if(i != n && j == n){
                    dp[i][j][0] = 0;
                }
                if(i == n && j != n){
                    dp[i][j][1] = 0;
                }
                if(map[i-1][j] ==1 || map[i][j-1] == 1){
                    dp[i][j][2] = 0;
                }
            }
        }
        long ans = 0 ;
        for(int i = 0 ; i < 3 ; i ++){
            ans += dp[n][n][i];
        }
        System.out.println(ans);
    }
}
