import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13251 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());
        int[] numArr = new int[M];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum = 0;
        for(int i = 0 ; i < M ; i ++){
            numArr[i] = Integer.parseInt(st.nextToken());
            sum += numArr[i];
        }
        int K = Integer.parseInt(bf.readLine());
        double[] dp = new double[51];
        double ans = 0;
        for(int num : numArr){
            if(num >= K){
                if(dp[num] == 0){
                    double tmp = 1.0;
                    for(int i = 0 ; i < K ; i ++){
                        tmp *= (num - i);
                    }
                    dp[num] = tmp;
                }
                ans += dp[num];
            }
        }
        double tmp = 1.0;
        for(int i = 0 ; i < K ; i ++){
            tmp *= (sum-i);
        }
        System.out.printf("%.18f",ans/tmp);
    }
}
