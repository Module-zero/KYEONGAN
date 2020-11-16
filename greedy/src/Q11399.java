import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11399 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[] times = new int[n];
        String[] strArr = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            times[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(times);
        int[] dp = new int[n];
        dp[0] = times[0];
        int answer = dp[0] ;
        for(int i = 1 ; i < n ; i ++){
            dp[i] = dp[i-1]+times[i];
            answer += dp[i];
        }
        System.out.println(answer);
    }
}
