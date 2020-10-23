import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q13398 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] strArr = bf.readLine().split(" ");
        int[] numArr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        int[][] dp = new int[n][2]; // 0번은 순수, 1번은 삭제
        dp[0][0] = numArr[0];
        dp[0][1] = numArr[0];
        int max = numArr[1];
        for(int i = 1 ; i < n ; i ++){
            dp[i][0] = dp[i-1][0]+numArr[i] > numArr[i] ? dp[i-1][0]+numArr[i] : numArr[i];
            dp[i][1] = dp[i-1][0] > dp[i-1][1] + numArr[i] ? dp[i-1][0] : dp[i-1][1] + numArr[i];
            max = Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(max);
    }
}
