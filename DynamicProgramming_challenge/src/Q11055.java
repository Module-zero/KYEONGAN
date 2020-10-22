import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11055 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[] numArr = new int[n];
        int[] dp = new int[n];
        String[] strArr = bf.readLine().split(" ");
        for(int i = 0; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        dp[0] = numArr[0];
        int ans = dp[0];
        for(int i = 1 ; i < n ; i ++){
            int j = i;
            int dpMax = 0;
            while(--j >= 0){
                if(numArr[i] > numArr[j]){
                    dpMax = Math.max(dpMax,dp[j]);
                }
            }
            dp[i] = dpMax + numArr[i];
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
