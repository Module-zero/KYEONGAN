import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1932 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader (new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[][] triangle = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 1 ;j <= i ; j ++){
                triangle[i][j] = Integer.parseInt(strArr[j-1]);
            }
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n ; i ++){
            for(int j = 1 ; j <= i ; j ++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
            }
        }
        int max = 0;
        for(int num : dp[n]){
            max = Math.max(num,max);
        }
        System.out.println(max);
    }
}
