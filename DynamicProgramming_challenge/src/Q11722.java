import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11722 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[] numArr = new int[n+1];
        int[] dp = new int[n+1];

        String[] strArr = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1 ; i < n ; i ++){
            int dpTmp = 1;
            for(int j = i-1 ; j >= 0 ; j--){
                if(numArr[j] > numArr[i]){
                    dpTmp = Math.max(dp[j]+1,dpTmp);
                }
            }
            dp[i] = dpTmp;
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
