import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q15988 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        long[] dp = new long[1000001];
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 0 ; i < n ;i++){
            int num = Integer.parseInt(bf.readLine());
            if(dp[num] == 0) {
                for (int j = 4; j <= num; j++) {
                    dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;
                }
            }
            sb.append(dp[num]+"\n");
        }
        System.out.println(sb);
    }
}
