import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2133 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 2; i <=n ; i +=2){
            dp[i] = dp[i-2];
            if(i%2==0){
                for(int j = i ; j >=2 ; j -=2){
                    dp[i] += dp[j-2]*2;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
