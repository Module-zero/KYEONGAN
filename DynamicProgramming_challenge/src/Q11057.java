import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11057 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n+1][10]; // n개 0-9
        for(int i = 0 ; i <= 9 ; i ++){
            dp[1][i] = 1;
        }
        for(int i = 2 ; i <= n ; i ++){
            for(int j = 0 ; j <= 9 ; j ++){
                for(int k = 0 ; k <= j ; k++){
                    dp[i][j] += (dp[i-1][k])%10007;
                }
            }
        }
        int answer = 0;
        for(int num : dp[n]){
            answer = (answer + num)%10007;
        }
        System.out.println(answer);
    }
}
