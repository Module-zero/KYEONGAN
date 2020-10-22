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
        int[] dp = new int[n];
        dp[0] = Math.max(numArr[0],0);
        int max = 0;
        int min = 100001;
        boolean flag = false;
        for(int i = 1 ; i < n ; i ++){
            dp[i] = Math.max(numArr[i]+dp[i-1],0);
            for(int j = i ; j >= 0 ; j --){
                if(min > numArr[j]){
                    min = numArr[j];
                    flag = true;
                }
            }
            min = Math.min(min,0);
            System.out.println(min);
            if(flag){
                flag = false;
                dp[i] = dp[i] - min;
            }
            max = Math.max(dp[i], max);
            System.out.println(i+":"+max);
        }
        System.out.println(max);
    }
}
