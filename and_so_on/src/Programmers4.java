import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Programmers4 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(solution(n));
    }
    public static int solution(int n ){
        int answer = 0 ;
        int MOD = 1000000007;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i ++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        answer = dp[n];
        return answer;
    }
}
